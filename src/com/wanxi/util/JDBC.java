package com.wanxi.util;

import java.sql.*;

/**
 * 手写一个JDBC的步骤
 * 1.加载驱动
 * 2.得到数据库的连接
 * 3.编译sql语句
 * 4.执行sql语句
 * 5.返回结果集
 * 6.关闭连接
 */
public class JDBC {
    //    如果用的是5.？的版本，则驱动不需要加cj这个包
    private static final String DRIVENAME = "com.mysql.cj.jdbc.Driver";
    //    如果地址是本地，则可以省略地址jdbc:mysql:///canyin04?
//    如果报时区异常 the server time zone  则需要加时区为中国的时区 serverTimezone=UTC
//    如果保存的时候 Java是正常的，但数据库出现乱码，则需要加 useUnicode=true&characterEncoding=utf8
//    如果有多个参数参数，则需要用&符号连接
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/lv_shi?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "5946";

    private static Connection conn = null;
    //    private Statement st = null;
    private static PreparedStatement ppst = null;
    private static ResultSet rs = null;
//    PreparedStatement和Statement的区别？

    /**
     * 加载驱动
     */
    static {
        try {
//            反射，拿到对象
            Class.forName(DRIVENAME).newInstance();
        } catch (Exception e) {
            System.out.println("驱动加载失败：" + e.getMessage());
        }
    }

    /**
     * 连接数据库
     *
     * @return
     */
    private static Connection getConn() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("数据库连接失败：" + e.getMessage());
        }
        return conn;
    }

    /**
     * 数据更新（新增，修改，删除）
     *
     * @param sql
     * @return
     */
    public static Integer update(String sql) {
        conn = getConn();//得到数据库连接
        try {
//            编译sql语句
            ppst = conn.prepareStatement(sql);
//            执行sql语句
            return ppst.executeUpdate();
        } catch (SQLException e) {

        }
        return 0;
    }

    /**
     * 获取查询的结果集（无参）
     *
     * @param sql
     * @return
     */
    public static ResultSet getRs(String sql) {
        conn = getConn();
        try {
            ppst = conn.prepareStatement(sql);
            rs = ppst.executeQuery();
        } catch (SQLException e) {
            System.out.println("查询（无参）出错:" + e.getMessage());
        }
        return rs;
    }

    /**
     * 获取结果集
     *
     * @param sql
     * @param params
     * @return
     */
    public ResultSet getRs(String sql, Object[] params) {
        conn = getConn();
        try {
            ppst = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ppst.setObject(i + 1, params[i]);
                }
            }
            rs = ppst.executeQuery();
        } catch (SQLException e) {
            System.out.println("查询出错：" + e.getMessage());
        }

        return rs;
    }


    //    public List<Object> query(String sql, Object[] params){
//
//        List<Object> list = new ArrayList<Object>();
//        ResultSet rs = null;
//        if(params!=null){
//            rs = getRs(sql, params);
//        }else{
//            rs = getRs(sql);
//        }
//        ResultSetMetaData rsmd = null;
//        int columnCount = 0;
//
//        try {
//            rsmd = rs.getMetaData();
//            columnCount = rsmd.getColumnCount();
//            while(rs.next()){
//                Map<String, Object> map = new HashMap<String, Object>();
//                for(int i = 1;i<=columnCount;i++){
//                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));
//                }
//                list.add(map);
//            }
//        } catch (SQLException e) {
//            System.out.println("结果集解析出错："+e.getMessage());
//        } finally {
//            closeConn();
//        }
//        return list;
//    }
    private void closeConn() {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        if (ppst != null) {
            try {
                ppst.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
