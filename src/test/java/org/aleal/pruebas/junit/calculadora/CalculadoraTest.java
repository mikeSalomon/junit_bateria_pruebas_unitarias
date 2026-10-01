package org.aleal.pruebas.junit.calculadora;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    //Creamos métodos de ciclo de vida de las pruebas unitarias
    //BeforeAll, AfterAll, BeforeEach, AfterEach

    @BeforeAll
    public static void beforeAll(){
        //Ej:iniciar conexión bbdd
        System.out.println("Se ejecuta antes de todas las pruebas unitarias");
    }

    @AfterAll
    public static void afterAll(){
        //Ej: para cerrar la conexión a bbdd
        System.out.println("Se ejecuta después de todas las pruebas unitarias");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Se ejecuta antes de cada prueba unitaria");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Se ejecuta después de cada prueba unitaria");
    }

    @Test
    @DisplayName("Prueba unitaria para revisar la suma de la calculadora")
    public void sumarTest(){
        Calculadora calc = new Calculadora();

        assertEquals(6, calc.sumar(3, 3));
        assertNotEquals(7, calc.sumar(3, 3));
    }

    @Test
    @DisplayName("Prueba unitaria para revisar la división de la calculadora")
    //@Disabled("Deshabilitada prueba unitaria de División temporalmente")
    public void dividirTest() throws Exception{
        Calculadora calc = new Calculadora();

        assertTrue(calc.dividir(10, 2) == 5);
        assertFalse(calc.dividir(40, 2) == 3);
    }

    @Test
    public void arregloTest(){

        String [] arre1 = {"a", "b"};
        String [] arre2 = {"a", "b"};
        String [] arre3 = {"a", "c", "c"};

        assertArrayEquals(arre1, arre2);
        //assertArrayEquals(arre1, arre3);
    }

    @Test
    public void multiplicarTest(){
        Calculadora calc = new Calculadora();

        //compara ambos parámetros. Si ambos son 25 pasa el test. Son iguales
        assertSame(25, calc.multiplicar(5, 5));
        //El primer parámetro es 25, el segundo es 15. No son iguales, así que pasa el test
        assertNotSame(25, calc.multiplicar(3, 5));
    }

    // ---- Manejo de errores ----
    @Test
    @DisplayName("Test para probar las excepciones")
    public void dividirExceptionTest(){

        Calculadora calc = new Calculadora();
        Exception exception = assertThrows(Exception.class, () -> {
            calc.dividir(10, 0);
        });

        assertDoesNotThrow(() -> {
            calc.dividir(10, 2);
        });
    }

    // ---- Continuamos desde aquí ----

}