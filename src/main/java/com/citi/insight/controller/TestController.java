package com.citi.insight.controller;

import com.citi.insight.model.Test;
import com.citi.insight.repository.TestDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RequestMapping("/test")
@RestController
public class TestController {

    private static TestDao testDao = new TestDao();

    @RequestMapping("/returnAllTests/")
    @ResponseBody
    public List<Test> returnAllTests() throws SQLException {

      return testDao.returnAllTests();

    }

    @RequestMapping("/returnTestsWhere/{field}/equals/{value}")
    @ResponseBody
    public List<Test> returnTestsByFieldAndValue(@PathVariable("field") String field, @PathVariable("value")
            String value) throws SQLException {

        return testDao.returnTestByFieldAndValue(field, value);

    }
}
