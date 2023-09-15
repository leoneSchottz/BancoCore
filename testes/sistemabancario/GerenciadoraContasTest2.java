package sistemabancario;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Classe de teste criada para garantir o funcionamento das principais operações
 * sobre contas, realizadas pela classe {@link GerenciadoraContas}
 * 
 * @author Leone Schottz
 * @date 25/08/2023
 * 
 */

public class GerenciadoraContasTest2 {
	/**
	 * Função para fazer o teste basico de tranferencia bancaria de uma conta de origem para uma conta de destino
	 * @author Leone Schottz
	 * @date 25/08/2023
	 * 
	 */
	private GerenciadoraContas gerContas;
	private ContaCorrente conta01;
	private ContaCorrente conta02;
	
	 
	@Before
	public void setUp(){
	conta01 = new ContaCorrente(1, 0, true);
	conta02 = new ContaCorrente(2, 0, true);
		
		
		
	List<ContaCorrente> contasDoBanco = new ArrayList<ContaCorrente>();
	contasDoBanco.add(conta01);
	contasDoBanco.add(conta02);
	gerContas = new GerenciadoraContas(contasDoBanco);
		
	}
	
	@After
	public void tearDown(){
		gerContas.limpa();
	}
	
	@Test
	public void testeSaldoInsuficiente() {
		conta01.setSaldo(200);
		conta02.setSaldo(0);

		boolean resultadoTransferencia = gerContas.transfereValor(1, 200, 2);

		assertTrue(resultadoTransferencia);


	}

	@Test
	public void testeCriarNegativo() {
		conta01.setSaldo(-100);
		conta02.setSaldo(0);

		boolean resultadoTransferencia = gerContas.transfereValor(1, 200, 2);

		assertTrue(resultadoTransferencia);


	}

	@Test
	public void testeCriarNegativoDuplo() {
		conta01.setSaldo(-100);
		conta02.setSaldo(-100);

		boolean resultadoTransferencia = gerContas.transfereValor(1, 200, 2);

		assertTrue(resultadoTransferencia);


	}
}

	

