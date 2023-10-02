# HealthMath
A primeira etapa é fornecer uma imagem docker contendo o DB do PostGres com todas as tableas criadas já com dados de exemplo inseridos
Segunda etapa é entregar uma imagem docker contendo a API desenvolvida em java junto com o seu código fonte
Os parâmetros de configuração / acesso ao banco de dados (url, nome do banco, usuário e senha) devem ser parametrizados por variáveis de ambiente sem utilizar hardcode.
O sistema se trata de uma API para gestão de prontuários eletrônicos para uma clínica hospitalar. Os dados serão trafegados em formato JSON

Anotações:
Usuario é quem efetiva o atendimento
o tipo de atendimento é apenas consulta OU exame
caso o plano não seja particular com o hospital, informar nome do plano e número da carteirinha

# Dados a serem inseridos nas tabelas:
	CREATE TABLE Paciente (
		cpf_paciente VARCHAR PRIMARY KEY,
		nome VARCHAR,
		dt_nascimento DATE,
		endereco VARCHAR,
		email VARCHAR,
		nome_plano_saude VARCHAR,
		num_carteirinha INT
	);
	CREATE TABLE Usuario (
		cpf_usuario VARCHAR PRIMARY KEY,
		login VARCHAR UNIQUE,
		senha VARCHAR
	);
	CREATE TABLE Atendimento (
		numero_aten INT PRIMARY KEY,
		cpf_paciente VARCHAR,
		cpf_usuario VARCHAR,
		descr_aten TEXT,
		data_aten DATE,
		tipo_aten VARCHAR,
		FOREIGN KEY (cpf_paciente) REFERENCES Paciente(cpf_paciente),
		FOREIGN KEY (cpf_usuario) REFERENCES Usuario(cpf_usuario),
		valor_aten FLOAT
	);
	 	
	INSERT INTO Paciente (cpf_paciente, nome, dt_nascimento, endereco, email, nome_plano_saude, num_carteirinha)
	VALUES (08931732474, 'julio', '1985-02-28', 'Cruzadas-Feira', 'julio@gmail.com', 'santandersaude', 1082957),
		   (86519472853, 'marcio', '1998-06-30', 'Centro-Feira', 'marcioamaral@hotmail.com', 'itau saude', 295917);
	INSERT INTO Paciente (cpf_paciente, nome, dt_nascimento, endereco, email)
	VALUES (24819568345, 'emilia', '2001-03-31', 'Dobradinho-Calvaras', 'emiliasantos@gmail.com');
	
	INSERT INTO Usuario (cpf_usuario, login, senha)
	VALUES (847628561897, 'emacio@hotmail.com', 'emacio2201'), (826498175823, 'lucasadmin', 'r0s3tt3');
	
	INSERT INTO Atendimento (numero_aten, cpf_paciente, cpf_usuario, descr_aten, data_aten, tipo_aten, valor_aten)
	VALUES (251, 08931732474, 847628561897, 'exame de glicerina', '2023-04-30', 'exame', 349.99), 
	(252, 24819568345, 826498175823, 'consulta geral', '2023-07-14', 'consulta', 149.99);

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
