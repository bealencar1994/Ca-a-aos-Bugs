package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

public class CarroServiceImplTest {

    @Test
    public void carroDeveAcelerarCorretamente() {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro celtinha = new Carro("Azul", "Fiat", "Uno", 2015, 150);
        carroService.ligar(celtinha);

        // When
        carroService.acelerar(celtinha, 10);

        // Then
                     Assert.assertTrue(celtinha.getVelocidadeAtual() == 10);
    }

    @Test
    public void carroDeveLigarCorretamente() {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro celtinha = new Carro("vermelho", "marca", "modelo", 1990, 100);

        // When
        carroService.ligar(celtinha);

        // Then
        Assert.assertTrue(celtinha.isLigado());
    }

    @Test
    public void velocidadeNaoDeveSerMenorQueZero() {

        // Given:
        CarroService carroService = new CarroServiceImpl();
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 50);
        carroService.ligar(celtinha); // velocidade zero

        // When:
        carroService.frear(celtinha, 10);

        // Then:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamenteEAcelerarCorretamente() {
        // Diven:
        CarroService carroService = new CarroServiceImpl();
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 50);

        // When:
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 10);

        // Then:
        Assert.assertTrue(celtinha.isLigado());
        Assert.assertEquals(10, celtinha.getVelocidadeAtual());
    }

    @Test
    public void umCarroDeveIniciarDesligado() {
        // Given:
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 50);

        // When:
        // Then:
        Assert.assertFalse(celtinha.isLigado());
    }

    @Test
    public void carroNaoDeveDesligarEmMovimento() {
        // Given:
        CarroService carroService = new CarroServiceImpl();
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 250);
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 80);

        // When:
        while (celtinha.getVelocidadeAtual() > 0) {
            carroService.frear(celtinha, 10);
        }
        carroService.desligar(celtinha);

        // Then:
        Assert.assertFalse(celtinha.isLigado());
    }

    @Test
    public void carroDeveEstarParadoParaDesligar() {
        // Given:
        CarroService carroService = new CarroServiceImpl();
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 250);
        carroService.ligar(celtinha);
        carroService.acelerar(celtinha, 100);

        // When:
        carroService.frear(celtinha, 100);
        if(celtinha.getVelocidadeAtual() == 0) {
            carroService.desligar(celtinha);
        }

        // Then:
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
        Assert.assertFalse(celtinha.isLigado());

    }

    @Test
    public void naoDeveAcelerarDesligado() {
        // Given:
        CarroService carroService = new CarroServiceImpl();
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 250);
        // When:
        carroService.acelerar(celtinha, 10);
        // Then:
        Assert.assertEquals(0, celtinha.getVelocidadeAtual());
    }

    @Test
    public void carroQuandoLigadoDeveMostrarEstadoAtual() {
        CarroService carroService = new CarroServiceImpl();
        // Given:
        Carro celtinha = new Carro("Prata", "Chevrolet", "Celta", 2001, 250);
        // When:
        carroService.ligar(celtinha);
        // Then:
        Assert.assertTrue(celtinha.isLigado());
        carroService.estadoAtual(celtinha);
    }
}