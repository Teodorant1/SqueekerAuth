package sample;

import java.sql.*;
import java.util.ArrayList;

public class sqlrobot {
    static String USER = "okidokipaloki";
    static String PASS = "okidokipaloki";
    static String DB_URL = "jdbc:mysql://localhost:3306/squeekdb";


    public sqlrobot() {
    }

    public void insertuser(String name, String password, String domain) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO squeekdb.users (name , password , domain) VALUES ( ?, ? , ? )");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, domain);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public void deleteuser(String name) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM squeekdb.users WHERE name=?");
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public String pull_user(String name) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<user> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.users WHERE author = ?");
        preparedStatement.setString(1, name);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(new user(rs.getString("name"), rs.getString("password"), rs.getString("domain")));
        }
        conn.close();

        return resultHolder.get(0).toJSON();
    }

    public String getusers() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<user> resultHolder = new ArrayList<>();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.users");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(new user(rs.getString("name"), rs.getString("password"), rs.getString("domain")));
        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(resultHolder.get(i).toJSON());
            if ( i != resultHolder.size()-1) {stringBuilder.append(",");}
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void inserttenantdomain(String name, String author) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO squeekdb.tenantdomains (name , author ) VALUES ( ? , ? )");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, author);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public void deletetenantdomain(String name) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM squeekdb.tenantdomains WHERE name=?");
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public String pull_tenantdomain(String author) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<tenantdomain> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.tenantdomains WHERE author = ?");
        preparedStatement.setString(1, author);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(new tenantdomain(rs.getString("name"), rs.getString("author")));
        }
        conn.close();

        return resultHolder.get(0).toJSON();
    }

    public String gettenantdomains() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<tenantdomain> resultHolder = new ArrayList<>();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.tenantdomains");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(new tenantdomain(rs.getString("name"), rs.getString("author")));
        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(resultHolder.get(i).toJSON());
            if ( i != resultHolder.size()-1) {stringBuilder.append(",");}}
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    public void insertcontact(String fullname, String user, String org, int phonenumber) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO squeekdb.smscontacts (fullname , user , org , phonenumber) VALUES (?, ? , ? , ? ) ");
        preparedStatement.setString(1, fullname);
        preparedStatement.setString(2, user);
        preparedStatement.setString(3, org);
        preparedStatement.setInt(4, phonenumber);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public void deletecontact(String fullname, int phonenumber) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM squeekdb.smscontacts WHERE fullname=? AND phonenumber=?");

        preparedStatement.setString(1, fullname);
        preparedStatement.setInt(2, phonenumber);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public String get_contacts(String user) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<contact> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.smscontacts WHERE user=? ");
        preparedStatement.setString(1 , user);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(new contact(rs.getString("fullname"), rs.getString("user"), rs.getString("org"), rs.getString("phonenumber")));
        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(resultHolder.get(i).tojson());
            if ( i != resultHolder.size()-1) {stringBuilder.append(",");}

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void insertmessage(String user, String contact, String message, int size, String author ) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO squeekdb.smsmessages (user , contact , message , size, author) VALUES (?, ? , ? ,?, ? ) ");
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, contact);
        preparedStatement.setString(3, message);
        preparedStatement.setInt(4, size);
        preparedStatement.setString(5,author);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public String get_messages(String user, String contact) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<message> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.tenantdomains WHERE user= ? AND contact = ? ");
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, contact);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(new message(rs.getString("user"),rs.getString("contact"),rs.getString("message"),rs.getInt("size"),
                    rs.getString("author")));
        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(resultHolder.get(i).toJson());
            if ( i != resultHolder.size()-1) {stringBuilder.append(",");}

        }
        stringBuilder.append("]");
        return stringBuilder.toString();

    }

    public void deletemessage(String user, String contact, int size) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM squeekdb.messages WHERE user=? AND contact=? AND size=?");
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, contact);
        preparedStatement.setInt(3, size);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public void insertcampaign(String creator, String contact, String schedule, String datetime, String template) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO squeekdb.smscampaign (creator , contact , schedule , datetime, template) VALUES (?, ? , ? ,? , ? ) ");
        preparedStatement.setString(1, creator);
        preparedStatement.setString(2, contact);
        preparedStatement.setString(3, schedule);
        preparedStatement.setString(4, datetime);
        preparedStatement.setString(5, template);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public void deletecampaign(String creator, String contact, String schedule, String datetime, String template) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM squeekdb.smscapaign WHERE creator=? AND contact=? AND schedule=? AND datetime=? AND template=?");

        preparedStatement.setString(1, creator);
        preparedStatement.setString(1, contact);
        preparedStatement.setString(1, schedule);
        preparedStatement.setString(1, datetime);
        preparedStatement.setString(1, template);

        preparedStatement.executeUpdate();
        conn.close();
    }


    public String pull_campaigns(String author) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<campaign> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT Text FROM squeekdb.smscampaign WHERE author = ?");
        preparedStatement.setString(1, author);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(new campaign(rs.getString("creator"),rs.getString("contact"),
                    rs.getString("schedule"),rs.getString("datetime"),rs.getString("template")));

        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(resultHolder.get(i).toJson());
            if ( i != resultHolder.size()-1) {stringBuilder.append(",");}

        }
        stringBuilder.append("]");
        return stringBuilder.toString();

    }


}
