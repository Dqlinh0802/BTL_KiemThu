package com.tbn;

import com.tbn.pojo.Sach;
import com.tbn.services.SachServices;
import com.tbn.services.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class SachTester {
    

    private static Connection conn;
    
    @BeforeClass
    public static void setUp() {
        conn = Utils.getConn();
        System.out.println("------START----------");
    }
    
    @AfterClass
    public static void tearDown() {
        try {
            conn.close();
            System.out.println("--------END----------");
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Before
    public void startTest() {
        System.out.println("Start Test case");
    }

    @Test
    public void testNoFilters1() {
        try {
            List<Sach> kq1 = SachServices.getSach(null);
            List<Sach> kq2 = SachServices.getSach("");
            
            Assert.assertEquals(kq1.size(), kq2.size());
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testNoFilters2() {
        try {
            List<Sach> kq1 = SachServices.getSach(null);
            List<Sach> kq2 = SachServices.getSach("   ");
            
            Assert.assertEquals(kq1.size(), kq2.size());
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testDeleteSuccessful(){
        try {
            String id ="112";
            
            boolean kq = SachServices.deleteSach(id);
            Assert.assertTrue(kq);
            
            Sach q = SachServices.getSachById(id);
            
            Assert.assertNull(q);
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
