package cadastropoo;

import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Definindo a codificação para UTF-8
        System.setProperty("file.encoding", "UTF-8");

        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
        String prefixoArquivo;

        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Salvar Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar programa");
            System.out.print("Digite uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha.

            switch (opcao) {
                case 1 -> {
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        pessoaFisicaRepo.inserir(new PessoaFisica(pessoaFisicaRepo.obterTodos().size() + 1, nome, cpf, idade));
                    } else if (tipo == 2) {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();
                        pessoaJuridicaRepo.inserir(new PessoaJuridica(pessoaJuridicaRepo.obterTodos().size() + 1, nome, cnpj));
                    }
                }
                case 2 -> {
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        PessoaFisica pessoa = pessoaFisicaRepo.obter(id);
                        if (pessoa != null) {
                            System.out.print("Novo Nome: ");
                            pessoa.setNome(scanner.nextLine());
                            System.out.print("Novo CPF: ");
                            pessoa.setCpf(scanner.nextLine());
                            System.out.print("Nova Idade: ");
                            pessoa.setIdade(scanner.nextInt());
                            scanner.nextLine();
                            pessoaFisicaRepo.alterar(pessoa);
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipo == 2) {
                        PessoaJuridica pessoa = pessoaJuridicaRepo.obter(id);
                        if (pessoa != null) {
                            System.out.print("Novo Nome: ");
                            pessoa.setNome(scanner.nextLine());
                            System.out.print("Novo CNPJ: ");
                            pessoa.setCnpj(scanner.nextLine());
                            pessoaJuridicaRepo.alterar(pessoa);
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        pessoaFisicaRepo.excluir(id);
                    } else if (tipo == 2) {
                        pessoaJuridicaRepo.excluir(id);
                    }
                }
                case 4 -> {
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        PessoaFisica pessoa = pessoaFisicaRepo.obter(id);
                        if (pessoa != null) {
                            pessoa.exibir();
                        } else {
                            System.out.println("Pessoa Física não encontrada.");
                        }
                    } else if (tipo == 2) {
                        PessoaJuridica pessoa = pessoaJuridicaRepo.obter(id);
                        if (pessoa != null) {
                            pessoa.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica não encontrada.");
                        }
                    }
                }
                case 5 -> {
                    System.out.print("Tipo (1 - Física, 2 - Jurídica): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    if (tipo == 1) {
                        pessoaFisicaRepo.obterTodos().forEach(PessoaFisica::exibir);
                    } else if (tipo == 2) {
                        pessoaJuridicaRepo.obterTodos().forEach(PessoaJuridica::exibir);
                    }
                }
                case 6 -> {
                    System.out.print("Prefixo do Arquivo: ");
                    prefixoArquivo = scanner.nextLine();
                    try {
                        pessoaFisicaRepo.persistir(prefixoArquivo + ".fisica.bin");
                        pessoaJuridicaRepo.persistir(prefixoArquivo + ".juridica.bin");
                    } catch (Exception e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                }
                case 7 -> {
                    System.out.print("Prefixo do Arquivo: ");
                    prefixoArquivo = scanner.nextLine();
                    try {
                        pessoaFisicaRepo.recuperar(prefixoArquivo + ".fisica.bin");
                        pessoaJuridicaRepo.recuperar(prefixoArquivo + ".juridica.bin");
                    } catch (Exception e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                }
                case 0 -> {
                    System.out.println("Saindo do sistema. Até logo!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
