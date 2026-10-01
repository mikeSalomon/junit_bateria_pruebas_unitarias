package util;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.condition.DisabledOnOs;

public class UtilTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
        public void testSoloWindows(){
            System.out.println("Este test solo se ejecuta en Windows");
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    public void testSoloMacLinux(){
        System.out.println("Este test solo se ejecuta en Windows");
    }

    //Ésta prueba se va a deshabilitar si solo corre en cierto sistema operativo
    @Test
    @DisabledOnOs(OS.WINDOWS)
    public void testNoWindows(){
        System.out.println("Este test no se va a ejecutar en Windows");
    }

    @Test
    @DisabledOnOs({OS.MAC, OS.LINUX})
    public void testNoMacLinux(){
        System.out.println("Este test no se va a ejecutar en Mac ni Linux");
    }
}
