package Controller;

import java.util.concurrent.Semaphore;

public class ThreadControCarro extends Thread {

	private int idCarrinho;
	private static int Chegada;
	private static int Saida;
	private Semaphore sema;
	

	public ThreadControCarro(String string, Semaphore semaforo) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void run() {
		CarroAndando();
		
		try {
			sema.acquire();
			ParaCarro();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			sema.release();
		}
		SaindoCarro();
	}

	
	private void CarroAndando() {
		int disF = 1000;
		int varDis = (int) ((Math.random() * 101) + 100);
		int TM= 500;
		int disPe = 0;

		while (disPe < disF) {
			disPe += varDis;
			try {
				Thread.sleep(TM);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O nosso carro " + idCarrinho + " já andou " + disPe + " metros");
		}
		Chegada++;
		System.out.println("O Nosso carro " + idCarrinho + " etsá na posição" + Chegada + "º na chegada");
	}

	
	private void ParaCarro() {
		System.out.println("O carro"+idCarrinho+ "está Estacionado");
		int tP = (int) ((Math.random() * 510) + 500);
		try {
			Thread.sleep(tP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	private void SaindoCarro() {
		Saida++;
		System.out.println("O carro " + idCarrinho + " foi o " + Saida + " o. a sair");
	}
}