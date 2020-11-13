package com.lorance.ogel.dao;

import com.lorance.ogel.dao.mapper.ProductionRowMapper;
import com.lorance.ogel.model.Production;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import lombok.Setter;
import org.springframework.util.StringUtils;

@Service
@Setter
public class ProductionDAO {

    @Autowired NamedParameterJdbcTemplate namedParamJdbcTemplate;


//    FIXME: ArrayList<String>
    public List<Production> getMachineNames() {
        return namedParamJdbcTemplate.query(
                "SELECT DISTINCT(machine_name) FROM production ORDER BY machine_name ASC", new ProductionRowMapper());
    }



//    public List<Production> getNumGrossOutput(Map<String, Object> params){
//        int subHours = 24;
//        if ( params.containsKey("subHours") ) {
//            subHours = Integer.parseInt(params.get("subHours").toString());
//        }
//
//        return namedParamJdbcTemplate.query(
//        "SELECT machine_name, SUM(value) FROM Production" +
//                "WHERE" +
//                (!StringUtils.isEmpty((String)params.get(subHours)) ?
//                        "datetime_from>=(SELECT MAX(datetime_from) - interval :subHours hour FROM Production)": "") +
//                "AND" +
//                "variable_name = 'PRODUCTION'  GROUP BY machine_name HAVING SUM(value)",
//        params, new ProductionRowMapper());
//    }
//
//    public List<Production> getNumScrap(Map<String, Object> params){
//        int subHours = 24;
//        if ( params.containsKey("subHours") ) {
//            subHours = Integer.parseInt(params.get("subHours").toString());
//        }
//
//        return namedParamJdbcTemplate.query(
//                "SELECT machine_name, SUM(value) FROM Production" +
//                        "WHERE" +
//                        (!StringUtils.isEmpty((String)params.get(subHours)) ?
//                                "datetime_from>=(SELECT MAX(datetime_from) - interval :subHours hour FROM Production)": "") +
//                        "AND" +
//                        "variable_name = 'SCRAP'  GROUP BY machine_name HAVING SUM(value)",
//                params, new ProductionRowMapper());
//    }
//
//    public List<Production> getNumGrossOutputPerHour(Map<String, Object> params){
//        int subHours = 24;
//        if ( params.containsKey("subHours") ) {
//            subHours = Integer.parseInt(params.get("subHours").toString());
//        }
//
//        return namedParamJdbcTemplate.query(
//                "SELECT machine_name, SUM(value) FROM Production" +
//                        "WHERE" +
//                        (!StringUtils.isEmpty((String)params.get(subHours)) ?
//                                "datetime_from>=(SELECT MAX(datetime_from) - interval :subHours hour FROM Production)": "") +
//                        "AND" +
//                        "variable_name = 'PRODUCTION'  GROUP BY machine_name HAVING SUM(value)",
//                params, new ProductionRowMapper());
//    }
//
//    public ArrayList<Object[]> getNumGrossOutputPerHour(String desireDate){
//        ArrayList<Object[]> res = new ArrayList<>();
//        try {
//            resultSet = statement.executeQuery("select machine_name,hour(datetime_from), sum(value) from production where DATE(datetime_from) =  '" + desireDate
//                    + "' and variable_name = 'PRODUCTION' GROUP BY machine_name, hour(datetime_from)  HAVING sum(value)");
//            while (resultSet.next()) {
//                Object[] row=new Object[3];
//                row[0]=resultSet.getString("machine_name");
//                row[1]=resultSet.getString("hour(datetime_from)");
//                row[2]=resultSet.getInt("sum(value)");
//                res.add(row);
//            }
//
//        } catch (Exception e) {
//            System.out.println("getNumGrossOutputPerHour:: " + e.getMessage());
//        }
//        return res;
//    }
//
//    public List<Production> getNumScrapPerHour(Map<String, Object> params){
//        int subHours = 24;
//        if ( params.containsKey("subHours") ) {
//            subHours = Integer.parseInt(params.get("subHours").toString());
//        }
//
//        return namedParamJdbcTemplate.query(
//                "SELECT machine_name, SUM(value) FROM Production" +
//                        "WHERE" +
//                        (!StringUtils.isEmpty((String)params.get(subHours)) ?
//                                "datetime_from>=(SELECT MAX(datetime_from) - interval :subHours hour FROM Production)": "") +
//                        "AND" +
//                        "variable_name = 'PRODUCTION'  GROUP BY machine_name HAVING SUM(value)",
//                params, new ProductionRowMapper());
//    }
//
//    public ArrayList<Object[]> getNumScrapPerHour(String desireDate){
//        ArrayList<Object[]> res = new ArrayList<>();
//        try {
//            resultSet = statement.executeQuery("select machine_name,hour(datetime_from), sum(value) from production where DATE(datetime_from) =  '" + desireDate
//                    + "' and variable_name = 'SCRAP' GROUP BY machine_name, hour(datetime_from)  HAVING sum(value)");
//            while (resultSet.next()) {
//                Object[] row=new Object[3];
//                row[0]=resultSet.getString("machine_name");
//                row[1]=resultSet.getString("hour(datetime_from)");
//                row[2]=resultSet.getInt("sum(value)");
//                res.add(row);
//            }
//
//        } catch (Exception e) {
//            System.out.println("getNumScrapPerHour:: " + e.getMessage());
//        }
//        return res;
//    }
//
//    //assignment B
//    //we will check how many times the condition is met (every 15 minutes)
//    public boolean isWarning(String desireDate,String machineName){
//        ArrayList<Integer> res = new ArrayList<>();
//        try {
//            resultSet = statement.executeQuery("select FLOOR(UNIX_TIMESTAMP(datetime_from)/(15 * 60)) AS timekey, count(*)" +
//                    " from production where DATE(datetime_from) = '"+desireDate
//                    +"' and machine_name ='"+machineName
//                    +"'  and variable_name = 'CORE TEMPERATURE' " +
//                    "and (value> 85 and value <=100) GROUP BY timekey HAVING count(*)");
//
//            while (resultSet.next()) {
//                int count=resultSet.getInt("count(*)");
//                res.add(count);
//            }
//
//        } catch (Exception e) {
//            System.out.println("getNumScrapPerHour:: " + e.getMessage());
//        }
//        for (Integer element : res) {
//            if(element>0)
//                return true;
//        }
//        return false;
//    }
//
//    public boolean isFatal(String desireDate,String machineName){
//        try {
//            resultSet = statement.executeQuery("select  count(*) from production where DATE(datetime_from) = '"+desireDate+"' and machine_name ='"+machineName+"' and variable_name = 'CORE TEMPERATURE' and value >100");
//            resultSet.next();
//            int count = resultSet.getInt("count(*)");
//            resultSet.close();
//            if (count > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            System.out.println("isFatal:: " + e.getMessage());
//        }
//        return false;
//    }
}