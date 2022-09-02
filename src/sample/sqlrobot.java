package sample;


import java.sql.*;
import java.util.ArrayList;

public class sqlrobot {
    static String USER = "root";
    static String PASS = "root";
    static String DB_URL = "jdbc:mysql://localhost:3306/squeekdb";


    public sqlrobot() {
    }

    public String pull_number_byuser(String user) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<String> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.users WHERE usernumber = ?");
        preparedStatement.setString(1, user);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add((rs.getString("usernumber")));
        }
        conn.close();

        return resultHolder.get(0);
    }
    public String pull_number_bycontact(String contact) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<String> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.smscontacts WHERE usernumber = ?");
        preparedStatement.setString(1, contact);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add((rs.getString("phonenumber")));
        }
        conn.close();

        return resultHolder.get(0);
    }

    public String pull_user_bynumber(String usernumber) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<String> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.users WHERE usernumber = ?");
        preparedStatement.setString(1,usernumber);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add((rs.getString("name")));
        }
        conn.close();
        System.out.println(resultHolder.get(0));
        return resultHolder.get(0);
    }

    public String pull_contact_bynumber(String phonenumber) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<String> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.smscontacts WHERE phonenumber = ?");
        preparedStatement.setString(1,phonenumber);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add((rs.getString("fullname")));
        }
        conn.close();
        System.out.println(resultHolder.get(0));
        return resultHolder.get(0);
    }


    public void insertuser(String name, String password, String usernumber, String domain) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO squeekdb.users" +
                " (name , password, usernumber , domain) VALUES ( ?, ?, ?, ? )");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, usernumber);
        preparedStatement.setString(4, domain);
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
            resultHolder.add(
                    new user(rs.getString("name"),
                             rs.getString("password"),
                             rs.getString("usernumber"),
                             rs.getString("domain")));
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
            resultHolder.add(new user(rs.getString("name"), rs.getString("password"),
                    rs.getString("usernumber"), rs.getString("domain")));
        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(resultHolder.get(i).toJSON());
            if (i != resultHolder.size() - 1) {
                stringBuilder.append(",");
            }
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
            if (i != resultHolder.size() - 1) {
                stringBuilder.append(",");
            }
        }
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

    public String get_contact_messages(String user) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<String> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.smscontacts WHERE user=? ");
        preparedStatement.setString(1, user);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(rs.getString("fullname"));
        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(
                    this.get_messages(user, resultHolder.get(i))
            );
            if (i != resultHolder.size() - 1) {
                stringBuilder.append(",");
            }

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String get_contacts(String user) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<contact> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.smscontacts WHERE user=? ");
        preparedStatement.setString(1, user);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(new contact(rs.getString("fullname"), rs.getString("user"), rs.getString("org"), rs.getString("phonenumber")));
        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(resultHolder.get(i).tojson());
            if (i != resultHolder.size() - 1) {
                stringBuilder.append(",");
            }

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void insertmessage(String user, String contacts, String message, String author, String media, int segments) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO squeekdb.smsmessages (user , contacts , message , author, media, segments ) " +
                "VALUES (?, ? , ? , ? , ?, ? ) ");
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, contacts);
        preparedStatement.setString(3, message);
        preparedStatement.setString(4, author);
        preparedStatement.setString(5, media);
        preparedStatement.setInt(6, segments);
        preparedStatement.executeUpdate();
        conn.close();
    }

    public String get_messages(String user, String contact) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<message> resultHolder = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM squeekdb.smsmessages WHERE user= ? AND contacts = ? ");
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, contact);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            resultHolder.add(new message
                    (rs.getString("user"),
                            rs.getString("contacts"),
                            rs.getString("message"),
                            rs.getString("author"),
                            rs.getString("media"),
                            rs.getInt("id")));
        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(resultHolder.get(i).toJson());
            if (i != resultHolder.size() - 1) {
                stringBuilder.append(",");
            }

        }
        stringBuilder.append("]");
        final String symbol = "\"";
        String finaljson =
                "{" + symbol + "Name" + symbol + ":" + symbol + contact + symbol + "," +
                        symbol + "messages" + symbol + ":" + symbol + stringBuilder.toString() + symbol +

                        "}";


        return finaljson;

    }

    public void deletemessage(String user, String contact, String message) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM squeekdb.messages WHERE user=? AND contacts=? AND message=?");
        preparedStatement.setString(1, user);
        preparedStatement.setString(2, contact);
        preparedStatement.setString(3, message);
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
            resultHolder.add(new campaign(rs.getString("creator"), rs.getString("contact"),
                    rs.getString("schedule"), rs.getString("datetime"), rs.getString("template")));

        }
        conn.close();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < resultHolder.size(); i++) {
            stringBuilder.append(resultHolder.get(i).toJson());
            if (i != resultHolder.size() - 1) {
                stringBuilder.append(",");
            }

        }
        stringBuilder.append("]");
        return stringBuilder.toString();

    }


}
