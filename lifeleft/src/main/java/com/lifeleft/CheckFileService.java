package com.lifeleft;


import javax.jws.WebMethod;
import javax.jws.WebService;

import java.sql.*;


@WebService(serviceName = "CheckFile")
public class CheckFileService {

    Motor motor;

    //Constructor
    public CheckFileService(){

    }

    @WebMethod
    public String checkFile (boolean statutOp, String info, String operationName, String tokenApp, String tokenUser, String appVersion, String operationVersion) {

        //Build The message
        Message message = new Message(statutOp, info, operationName, tokenApp, tokenUser, appVersion, operationVersion);

        //Select motor
        if((message.operationName == "checkFile") && (message.appVersion == "1")){
            this.motor = new Motor1(message);
        }
        else{
            return "Aucune opération trouvé";
        }

        return this.motor.run();
    }

    @WebMethod
    public String testBDD(String word){

        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "test";

        /*try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //try {
                /*Connection con = DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:ORCLCDB.localdomain","choco","choco");
                Statement statement = con.createStatement();*/
                /*String sql = "select * from dico where words = " + word + ";";
                ResultSet rs = statement.executeQuery(sql);*/
                /*while(rs.next()){
                    return "On a";
                }*/
                //return "On a pa";

            //} catch (SQLException throwables) {
                //throwables.printStackTrace();
               // return "crash";
            //}


        //} catch (ClassNotFoundException e) {
            //e.printStackTrace();
            //return "crash";
        //}

    }


    //Verify AppToken
    private boolean verifApp(){

        return true;
    }


}
