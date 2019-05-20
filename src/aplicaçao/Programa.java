package aplicaçao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Processo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Scanner prov = new Scanner(System.in);
		String val;

		do {
			System.out.println("ESCOLHA UMA OPÇÃO...\n");
			System.out.println("1-Inserir registro");
			System.out.println("2-Listar registro");
			System.out.println("3-Alterar registro");
			System.out.println("4-Remover registro");
			System.out.println("0-Sair");
			val = prov.nextLine();
			if (val.equals("1")) {
				System.out.println("Digite os nomes do cliente e do advogado, respectivamente: ");

				Processo processo = new Processo(null, prov.nextLine(), prov.nextLine());
				entityManager.getTransaction().begin();
				entityManager.persist(processo);
				entityManager.getTransaction().commit();

			} else if (val.equals("2")) {

				String jpql = "SELECT p FROM Processo p";
				List<Processo> processos = entityManager.createQuery(jpql, Processo.class).getResultList();
				System.out.println(processos);
			} else if (val.equals("3")) {
				System.out.println("escolha o id que deseja alterar");
				Processo processoFound = entityManager.find(Processo.class, Integer.parseInt(prov.nextLine()));
				System.out.println("Digite o novo nome para o cliente");
				processoFound.setCliente(prov.nextLine());
				System.out.println("Digite o novo nome para o advogado");
				processoFound.setAdvogado(prov.nextLine());
				entityManager.getTransaction().begin();
				entityManager.persist(processoFound);
				entityManager.getTransaction().commit();

			} else if (val.equals("4")) {
				System.out.println("Digite o ID a ser apagado: ");
				Processo processoFound = entityManager.find(Processo.class, Integer.parseInt(prov.nextLine()));
				entityManager.getTransaction().begin();
				entityManager.remove(processoFound);
				entityManager.getTransaction().commit();

			}
		} while (!val.equals("0"));
		System.out.println("Fechando programa...Até breve!");
		entityManager.close();
		entityManagerFactory.close();
		System.exit(0);

	}

}
