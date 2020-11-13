package com.lorance.ogel;

import com.lorance.ogel.dao.ProductionDAO;
import com.lorance.ogel.dao.mapper.ProductionRowMapper;
import com.lorance.ogel.model.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Production production;

        ProductionDAO productionDAO = new ProductionDAO();
        System.out.println(productionDAO.getMachineNames());
    }

}
