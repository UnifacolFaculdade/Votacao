# Sistema de Votação 

## ❤️ Objetivo do Projeto  


## 🛠️ Funcionalidades  
- **Cadastro de pautas**  
- **Cadastrar uma nova pauta**
- **Abrir uma sessão de votação para uma pauta, com tempo determinado**
- **Receber votos dos associados (Sim/Não). Cada associado tem um ID único e pode votar apenas uma vez por pauta**
- **Contabilizar os votos e exibir o resultado da votação**

## 🚀 Tecnologias Utilizadas  
- **Java** (Spring Boot)  
- **Banco de Dados**: PostgreSQL   
- **Controle de versão**: Git e GitHub  

## 📚 Wiki  


##  🖌️Modelo de domínio Votação
![image](https://github.com/user-attachments/assets/8adf3516-7d14-43c2-b748-bcabd40d6326)







## ⚙️ Como Configurar o Projeto  

Siga os passos abaixo para configurar e rodar o projeto localmente.

### ✅ Pré-requisitos  
Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:  
1. [**Java 21LTS+**](https://www.oracle.com/java/technologies/javase-downloads.html)  
   - Certifique-se de que o Java esteja no **PATH** da sua máquina.  
   - Verifique a instalação executando no terminal:  
     ```bash
     java -version
     ```  
2. [**Maven**](https://maven.apache.org/download.cgi)  
   - Após a instalação, verifique se o Maven está no **PATH**:  
     ```bash
     mvn -version
     ```  
3. [**PostgreSQL**](https://www.postgresql.org/download/)  
   - Crie um banco de dados no PostgreSQL com um nome, usuário e senha de sua preferência.  
   - Configure as credenciais no arquivo `application.yml`.  

4. [**Git**](https://git-scm.com/downloads)  
   - Necessário para clonar o repositório.
     ```bash
     mvn -version
     ```  

5. IDE de sua escolha:  
   - Recomendado: [**Visual Studio Code**](https://code.visualstudio.com/) ou [**IntelliJ**](https://www.jetbrains.com/pt-br/idea/).  

---

### 🚀 Passo a Passo para Rodar o Projeto  

1. **Clone o Repositório**  
   Execute o seguinte comando no terminal para clonar o projeto:  
   ```bash
   git clone https://github.com/UnifacolFaculdade/Votacao
   ```
   
2. Instale as Dependências
No diretório do projeto, execute o comando para baixar as dependências:
```bash
   mvn clean install
```
3.Execute o Projeto
Para iniciar o servidor Spring Boot, rode:
```bash
mvn spring-boot:run
```
