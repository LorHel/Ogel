//package com.lorance.ogel.dao;
//
//import com.lorance.ogel.dao.mapper.RuntimeRowMapper;
//import com.lorance.ogel.model.Runtime;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import lombok.Setter;
//
//@Service
//@Setter
//public class RuntimeDAO {
//
//    public ArrayList<Object[]> getNumUptime(String desireDate){
//        ArrayList<Object[]> res = new ArrayList<>();
//        try {
//            resultSet = statement.executeQuery("select machine_name, count(*) from runtime where DATE(datetime) =  '" + desireDate +
//                    "' and isrunning = '1' GROUP BY machine_name HAVING count(*)");
//            while (resultSet.next()) {
//                Object[] row=new Object[2];
//                row[0]=resultSet.getString("machine_name");
//                row[1]=resultSet.getInt("count(*)");
//                res.add(row);
//            }
//
//        } catch (Exception e) {
//            System.out.println("getNumUptime: " + e.getMessage());
//        }
//        return res;
//    }
//
//    public ArrayList<Object[]> getNumDowntime( String desireDate){
//        ArrayList<Object[]> res = new ArrayList<>();
//        try {
//            resultSet = statement.executeQuery("select machine_name, count(*) from runtime where DATE(datetime) =  '" + desireDate +
//                    "' and isrunning = '0' GROUP BY machine_name HAVING count(*)");
//            while (resultSet.next()) {
//                Object[] row=new Object[2];
//                row[0]=resultSet.getString("machine_name");
//                row[1]=resultSet.getInt("count(*)");
//                res.add(row);
//            }
//        } catch (Exception e) {
//            System.out.println("getNumDowntime: " + e.getMessage());
//        }
//        return res;
//    }
//}
