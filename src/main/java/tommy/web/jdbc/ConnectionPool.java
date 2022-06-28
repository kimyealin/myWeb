package tommy.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
        static {
                try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                } catch (ClassNotFoundException cnfe) {
                        cnfe.printStackTrace();
                }
        }
        // ������� ���� Ŀ�ؼ� ��, �ʱ� Ŀ�ؼ��� �����ϴ� ����
        private ArrayList<Connection> free;
        private ArrayList<Connection> used; // ������� Ŀ�ؼ��� �����ϴ� ����
        private String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        private String user = "mytest";
        private String password = "mytest";
        private int initialCons = 10; // ���ʷ� �ʱ� Ŀ�ؼǼ�
        private int maxCons = 20; // �ִ� Ŀ�ؼǼ�
        private int numCons = 0; // �� Connection ��
        private static ConnectionPool cp;

        public static ConnectionPool getInstance() {
                try {
                        if (cp == null) {
                                synchronized (ConnectionPool.class) {
                                        cp = new ConnectionPool();
                                }
                        }
                } catch (SQLException sqle) {
                        sqle.printStackTrace();
                }
                return cp;
        }

        private ConnectionPool() throws SQLException {
                /*
                 * �ʱ� Ŀ�ؼ� ������ ������ ArrayList�� ������ �� �ֵ��� �ʱ� Ŀ�ؼ� ����ŭ ArrayList ����.
                 */
                free = new ArrayList<Connection>(initialCons);
                used = new ArrayList<Connection>(initialCons);
                // initialCons ����ŭ Connection ����(free)
                while (numCons < initialCons) {
                        addConnection();
                }
        }

        // free�� Ŀ�ؼ� ��ü�� ������.
        private void addConnection() throws SQLException {
                free.add(getNewConnection());
        }

        // ���ο� Ŀ�ؼ� ��ü�� ������.
        private Connection getNewConnection() throws SQLException {
                Connection con = null;
                try {
                        con = DriverManager.getConnection(url, user, password);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                System.out.println("About to connect to " + con);
                ++numCons; // ���ؼ� ������ �� ���� ���� ����
                return con;
        }

        /* free�� �ִ� Ŀ�ؼ��� used �� �ű�� �۾�=>free--->used */
        public synchronized Connection getConnection() throws SQLException {
                /*
                 * free�� Connection�� ������ maxCons��ŭ Connection�� �� �����Ѵ�.
                 */
                if (free.isEmpty()) {
                        while (numCons < maxCons) {
                                addConnection();
                        }
                }
                Connection _con;
                _con = free.get(free.size() - 1);
                free.remove(_con);
                used.add(_con);
                return _con;
        }

        /* used�� �ִ� Ŀ�ؼ��� free�� �ݳ���. */
        public synchronized void releaseConnection(Connection _con) throws SQLException {
                boolean flag = false;
                if (used.contains(_con)) {
                        used.remove(_con);
                        numCons--;
                        flag = true;
                } else {
                        throw new SQLException("ConnectionPool" + "�� �����ʳ׿�!!");
                }
                try {
                        if (flag) {
                                free.add(_con);
                                numCons++;
                        } else {
                                _con.close();
                        }
                } catch (SQLException e) {
                        try {
                                _con.close();
                        } catch (SQLException e2) {
                                e2.printStackTrace();
                        }
                }
        }

        public void closeAll() {// ��� Connection �ڿ��� �ݳ���.
                // used�� �ִ� Ŀ�ؼ��� ��� ������ ����.
                for (int i = 0; i < used.size(); i++) {
                        Connection _con = (Connection) used.get(i);
                        used.remove(i--);
                        try {
                                _con.close();
                        } catch (SQLException sqle) {
                                sqle.printStackTrace();
                        }
                }
                // free�� �ִ� Ŀ�ؼ��� ��� ������ ����.
                for (int i = 0; i < free.size(); i++) {
                        Connection _con = (Connection) free.get(i);
                        free.remove(i--);
                        try {
                                _con.close();
                        } catch (SQLException sqle) {
                                sqle.printStackTrace();
                        }
                }
        }

        public int getMaxCons() {
                return maxCons;
        }

        public int getNumCons() {
                return numCons;
        }
}