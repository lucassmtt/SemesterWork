# TrabalhoSemestreA3
Projeto voltado para trabalho A3 do semestre.

Definições sobre o projeto
• O trabalho é individual ou em equipe de dois alunos no máximo;
• O trabalho deverá ser desenvolvido em Java e deve usar abordagem de OO;
• O projeto deve ser desenvolvido em Console ou utilizando algum sistema de
interface gráfica compatível com a linguagem Java;
• A qualidade geral de programação do projeto estará sendo avaliada.
• A interface gráfica não é o enfoque do projeto, contudo, o projeto deve estar
funcional e sem bugs;

Especificação sobre o projeto
• Você foi contratado por uma empresa que realiza cursos em diversas áreas com temática fixa. Exemplo:
Curso de Eletricidade básica, Curso de mecânica de automóveis, Curso de cabelereiro/estética. Etc...
• A empresa só ministra curso no horário NOTURNO, das 19:00 as 23:00 horas, somente nos dias uteis
(segunda...sexta).
• A empresa está crescendo e necessita de um sistema para controle de seus cursos, professores, alunos e
salas.
• Os cursos possuem professores que ministram estes cursos.
• Cada professor possui turmas de alunos e cada turma pertence a uma sala especifica. Logo não pode haver
duas turmas alocadas para a mesma sala. E não pode o professor dar aula para duas turmas diferentes no
mesmo dia.
• Cada sala tem limite de capacidade, logo a quantidade de alunos não pode ultrapassar a capacidade da sala
para qual este turma esta alocada.
• O sistema deve ter inicialmente os cadastros zerados (vazios) e a medida que surgem cursos, estes devem
poder serem cadastrados no sistema, bem como professores, turmas, salas e alunos.
• Portanto o sistema deverá possuir :
– Cadastro de aluno
– Cadastro de salas
– Cadastro de cursos
– Cadastro de turmas
– Cadastro de professores

As entidades abaixo, devem possuir no mínimo os seguintes atributos
• Aluno:
– matrícula, nome completo, cpf, endereço, e-mail e celular.
• Professor :
– cpf, nome completo, código de funcionário, endereço, e-mail e celular.
– observe que Aluno e Professor possuem atributos em comum e isso pode ser melhor modelado na
solução;
• Curso:
– código do curso, nome do curso, carga horária, descrição sobre o curso;
• Salas:
– nome, local e capacidade total;
– Lembre-se de quando associar uma determinada turma a uma sala , definir em que dia da semana
existe aula, pois um professor não pode dar aula para duas turmas diferentes no mesmo dia.
• O sistema deverá gerar uma lista (em tela) dos cursos ativos, mostrando o nome do curso, o
professor, sala alocada e a lista dos alunos;
• Poderá haver alunos a espera por curso... Ou seja, alunos que aguardam serem encaixados
numa turma, sala e professor.
• O sistema deverá persistir os dados em arquivo (csv, json, xml, txt) ou em banco de dados.
• O sistema devera obviamente ao ser inicializado ler os dados persistidos.
• O sistema pode obviamente ter mais entidades que possam ser necessárias para
implementa-lo.
