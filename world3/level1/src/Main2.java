import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class Main2 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String opcao = "";
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        while (!"0".equals(opcao)) {
            System.out.println("===================================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("===================================");

            try {
                opcao = reader.readLine();

                switch (opcao) {
                    case "1":
                        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                        String tipoPessoa = reader.readLine();
                        switch (tipoPessoa) {
                            case "F":
                                PessoaFisica pf = lerDadosPessoaFisica(reader);
                                repoFisica.inserir(pf);
                                System.out.println("Pessoa Física incluída com sucesso.");
                                break;
                            case "J":
                                PessoaJuridica pj = lerDadosPessoaJuridica(reader);
                                repoJuridica.inserir(pj);
                                System.out.println("Pessoa Jurídica incluída com sucesso.");
                                break;
                            default:
                                System.out.println("Tipo inválido.");
                        }
                        break;

                    case "2":
                        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                        String tipoPessoaAlterar = reader.readLine();
                        switch (tipoPessoaAlterar) {
                            case "F":
                                alterarPessoa(repoFisica, reader);
                                System.out.println("Pessoa Física alterada com sucesso.");
                                break;
                            case "J":
                                alterarPessoa(repoJuridica, reader);
                                System.out.println("Pessoa Jurídica alterada com sucesso.");
                                break;
                            default:
                                System.out.println("Tipo inválido.");
                        }
                        break;

                    case "3":
                        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                        String tipoPessoaExcluir = reader.readLine();
                        switch (tipoPessoaExcluir) {
                            case "F":
                                excluirPessoa(repoFisica, reader);
                                System.out.println("Pessoa Física excluída com sucesso.");
                                break;
                            case "J":
                                excluirPessoa(repoJuridica, reader);
                                System.out.println("Pessoa Jurídica excluída com sucesso.");
                                break;
                            default:
                                System.out.println("Tipo inválido.");
                        }
                        break;

                    case "4":
                        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                        String tipoPessoaBuscar = reader.readLine();
                        switch (tipoPessoaBuscar) {
                            case "F":
                                buscarPessoa(repoFisica, reader);
                                System.out.println("Pessoa Física encontrada com sucesso.");
                                break;
                            case "J":
                                buscarPessoa(repoJuridica, reader);
                                System.out.println("Pessoa Jurídica encontrada com sucesso.");
                                break;
                            default:
                                System.out.println("Tipo inválido.");
                        }
                        break;

                    case "5":
                        System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                        String tipoPessoaExibirTodos = reader.readLine();
                        switch (tipoPessoaExibirTodos) {
                            case "F":
                                exibirTodasPessoas(repoFisica);
                                System.out.println("Listagem de todas as Pessoas Físicas cadastradas.");
                                break;
                            case "J":
                                exibirTodasPessoas(repoJuridica);
                                System.out.println("Listagem de todas as Pessoas Jurídicas cadastradas.");
                                break;
                            default:
                                System.out.println("Tipo inválido.");
                        }
                        break;

                    case "6":
                        System.out.print("Qual o nome dos arquivos? ");
                        String arquivoP = reader.readLine();
                        try {
                            repoFisica.persistir(arquivoP + ".fisica.bin");
                            repoJuridica.persistir(arquivoP + ".juridica.bin");
                            System.out.println("Dados salvos com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar os dados: " + e.getMessage());
                        }
                        break;

                    case "7":
                        System.out.print("Qual o nome dos arquivos? ");
                        String arquivoR = reader.readLine();
                        try {
                            repoFisica.recuperar(arquivoR + ".fisica.bin");
                            repoJuridica.recuperar(arquivoR + ".juridica.bin");
                            System.out.println("Dados recuperados com sucesso.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                        }
                        break;

                    case "0":
                        System.out.println("Finalizando o programa...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Erro de entrada/saída: " + e.getMessage());
            }
        }
    }

    private static PessoaFisica lerDadosPessoaFisica(BufferedReader reader) throws IOException {
        System.out.println("Digite o id da pessoa: ");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Insira os dados...");
        System.out.print("Nome: ");
        String nome = reader.readLine();
        System.out.print("CPF: ");
        String cpf = reader.readLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(reader.readLine());
        return new PessoaFisica(id, nome, cpf, idade);
    }

    private static PessoaJuridica lerDadosPessoaJuridica(BufferedReader reader) throws IOException {
        System.out.println("Digite o id da pessoa: ");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Insira os dados...");
        System.out.print("Nome: ");
        String nome = reader.readLine();
        System.out.print("CNPJ: ");
        String cnpj = reader.readLine();
        return new PessoaJuridica(id, nome, cnpj);
    }

    private static void alterarPessoa(Object repo, BufferedReader reader) throws IOException {
        System.out.println("Digite o id da pessoa: ");
        int id = Integer.parseInt(reader.readLine());
        if (repo instanceof PessoaFisicaRepo) {
            PessoaFisica pf = ((PessoaFisicaRepo) repo).obter(id);
            if (pf != null) {
                System.out.println("Nome atual: " + pf.getNome());
                System.out.print("Novo nome: ");
                pf.setNome(reader.readLine());
                System.out.println("CPF atual: " + pf.getCpf());
                System.out.print("Novo CPF: ");
                pf.setCpf(reader.readLine());
                System.out.println("Idade atual: " + pf.getIdade());
                System.out.print("Nova idade: ");
                pf.setIdade(Integer.parseInt(reader.readLine()));
                ((PessoaFisicaRepo) repo).alterar(pf);
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (repo instanceof PessoaJuridicaRepo) {
            PessoaJuridica pj = ((PessoaJuridicaRepo) repo).obter(id);
            if (pj != null) {
                System.out.println("Nome atual: " + pj.getNome());
                System.out.print("Novo nome: ");
                pj.setNome(reader.readLine());
                System.out.println("CNPJ atual: " + pj.getCnpj());
                System.out.print("Novo CNPJ: ");
                pj.setCnpj(reader.readLine());
                ((PessoaJuridicaRepo) repo).alterar(pj);
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        }
    }

    private static void excluirPessoa(Object repo, BufferedReader reader) throws IOException {
        System.out.print("Digite o Id do usuário: ");
        int id = Integer.parseInt(reader.readLine());
        if (repo instanceof PessoaFisicaRepo) {
            ((PessoaFisicaRepo) repo).excluir(id);
        } else if (repo instanceof PessoaJuridicaRepo) {
            ((PessoaJuridicaRepo) repo).excluir(id);
        }
    }

    private static void buscarPessoa(Object repo, BufferedReader reader) throws IOException {
        System.out.print("Digite o id da pessoa: ");
        int id = Integer.parseInt(reader.readLine());
        if (repo instanceof PessoaFisicaRepo) {
            PessoaFisica pf = ((PessoaFisicaRepo) repo).obter(id);
            if (pf != null) {
                System.out.println("Id: " + pf.getId());
                System.out.println("Nome: " + pf.getNome());
                System.out.println("CPF: " + pf.getCpf());
                System.out.println("Idade: " + pf.getIdade());
            } else {
                System.out.println("Pessoa Física não encontrada.");
            }
        } else if (repo instanceof PessoaJuridicaRepo) {
            PessoaJuridica pj = ((PessoaJuridicaRepo) repo).obter(id);
            if (pj != null) {
                System.out.println("Id: " + pj.getId());
                System.out.println("Nome: " + pj.getNome());
                System.out.println("CNPJ: " + pj.getCnpj());
            } else {
                System.out.println("Pessoa Jurídica não encontrada.");
            }
        }
    }

    private static void exibirTodasPessoas(Object repo) {
        if (repo instanceof PessoaFisicaRepo) {
            for (PessoaFisica pf : ((PessoaFisicaRepo) repo).obterTodos()) {
                System.out.println("Id: " + pf.getId());
                System.out.println("Nome: " + pf.getNome());
                System.out.println("CPF: " + pf.getCpf());
                System.out.println("Idade: " + pf.getIdade());
            }
        } else if (repo instanceof PessoaJuridicaRepo) {
            for (PessoaJuridica pj : ((PessoaJuridicaRepo) repo).obterTodos()) {
                System.out.println("Id: " + pj.getId());
                System.out.println("Nome: " + pj.getNome());
                System.out.println("CNPJ: " + pj.getCnpj());
            }
        }
    }
}