# HealthMath
A primeira etapa é fornecer uma imagem docker contendo o DB do PostGres com todas as tableas criadas já com dados de exemplo inseridos
Segunda etapa é entregar uma imagem docker contendo a API desenvolvida em java junto com o seu código fonte
Os parâmetros de configuração / acesso ao banco de dados (url, nome do banco, usuário e senha) devem ser parametrizados por variáveis de ambiente sem utilizar hardcode.
O sistema se trata de uma API para gestão de prontuários eletrônicos para uma clínica hospitalar. Os dados serão trafegados em formato JSON
# Dados a serem inseridos nas tabelas:
	Paciente {
		idPaciente: int, primaryKey
		cpf: varchar, 
		nome: varchar
		dtNascimento: date
		endereco: varchar
		email: varchat
		se não for por plano particular:
			nome_plano_saude: varchar
			num_carteirinha: int
	}
	Atendimento {
		idAten: int, primaryKey
		idPaciente: int, foreignKey
		nomePaciente: varchat
		descrAten: text
		dataAten: date
		tipoAten: varchar obs: é tipo consulta OU exame
		valorAten: float
		
	}
# Métodos HTTP:
->Salvar paciente (POST)
->Consultar dados de paciente por cpf (GET)
->Consultar cpf, nome e email de todos pacientes (GET)
->Atualizar dados do paciente (PUT) obs: cpf só pode ser alterado em caso de não haver um atendimento para o paciente
->Remover um paciente pelo CPF (DELETE) obs: apenas caso não existir um atendimento para ele

->Consultar todos os atendimentos de um determinado paciente (GET) obs: retornar cpf, nome, descr do at, data do at, tipo de at, valor do at.
-> Salvar atendimentos (POST)
->
