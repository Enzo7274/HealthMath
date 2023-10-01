# HealthMath
A primeira etapa é fornecer uma imagem docker contendo o DB do PostGres com todas as tableas criadas já com dados de exemplo inseridos
Segunda etapa é entregar uma imagem docker contendo a API desenvolvida em java junto com o seu código fonte
Os parâmetros de configuração / acesso ao banco de dados (url, nome do banco, usuário e senha) devem ser parametrizados por variáveis de ambiente sem utilizar hardcode.
O sistema se trata de uma API para gestão de prontuários eletrônicos para uma clínica hospitalar. Os dados serão trafegados em formato JSON
# Dados a serem inseridos nas tabelas:
	Paciente {
		cpf: varchar, primaryKey
		nome: varchar
		dtNascimento: date
		endereco: varchar
		email: varchar
		se não for por plano particular:
			nome_plano_saude: varchar
			num_carteirinha: int
	}
	Atendimento {
		numAten: int, primaryKey
		cpfPaciente: int, foreignKey
		cpfUsuario: int, foreignKey
		nomePaciente: varchar
		nomeUsuario: varchar (responsável que efetivou o atendimento)(
		descrAten: text
		dataAten: date
		tipoAten: varchar obs: é tipo consulta OU exame
		valorAten: float
	}
	Usuario {
		cpfUsuario: varchar, primaryKey
		login: varchar, unique
		senha: varchar
	}
# Métodos HTTP:
Paciente:
->Salvar paciente (POST)
[TODOS os dados]

->Consultar dados de paciente por cpf (GET)
[TODOS os dados]

->Consultar cpf, nome e email de todos pacientes (GET)

->Atualizar dados do paciente (PUT) obs: cpf só pode ser alterado em caso de não haver um atendimento para o paciente

[TODOS os dados]
->Remover um paciente pelo CPF (DELETE) obs: apenas caso não existir um atendimento para ele

Atendimento:
->Consultar todos os atendimentos de um determinado paciente (GET) obs: retornar cpf, nome, descr do at, data do at, tipo de at, valor do at.
[cpfPaciente, nomePaciente, descrAten, dataAten, tipoAten, valorAten]

-> Salvar atendimentos (POST)
[TODOS os dados]

->Consultar atendimentos por tipo (GET)
[numAten, cpfPaciente,nomePaciente, descrAten, dataAten, valorAten, cpfUsuario]

->Remover atendimentos a partir do número (DELETE)
[numAten]

Usuário:
->Salvar usuário (POST)
[TODOS os dados]

->Remover usuário (DELETE) obs: apenas quando o usuário não efetuou nenhum atendimento
[cpfUsuario]

->Atualizar usuário (PUT) obs: só atualiza o cpf se não tem nenhum atendimento relacionado
