# 📱 Controle de Hábitos — Entrega 2

Este é o projeto atualizado do aplicativo **Controle de Hábitos**, desenvolvido para a disciplina de **Dispositivos Móveis**, como parte da **Entrega 2**.  
Esta versão é uma **continuação direta da Entrega 1**, com novas funcionalidades e melhorias na estrutura do app.

---

## 🎯 Objetivo

Expandir a aplicação original adicionando uma tela principal que exibe uma lista de hábitos previamente cadastrados, utilizando um componente de listagem com Adapter customizado e recursos de interação.

A tela de cadastro (criada na Entrega 1) continua no projeto, mas **não é mais utilizada como tela inicial**.

---

## ✅ Funcionalidades da Entrega 2

Nesta entrega, foram implementadas as seguintes funcionalidades adicionais:

- Criação de uma nova `Activity` principal (Launcher) com listagem de hábitos.
- Definição de uma **entidade `Hábito`** com pelo menos 4 atributos.
- Dados carregados a partir de `arrays.xml`, com no mínimo 10 hábitos.
- Instanciação dos objetos e armazenamento em um `ArrayList`.
- Exibição dos hábitos em uma `ListView` com `Adapter` customizado.
- Exibição de um `Toast` com detalhes ao clicar em qualquer item da lista.

---

## 🗂️ Entidades Utilizadas

### 📌 Hábito (Entidade Principal)

| Campo       | Tipo     | Descrição                        |
|-------------|----------|----------------------------------|
| nome        | String   | Nome do hábito                   |
| categoria   | String   | Ex: Saúde, Leitura, Produtividade|
| nivel       | int      | Ex: dificuldade ou prioridade    |
| descricao   | String   | Descrição do hábito              |

> Os dados foram carregados diretamente dos arrays definidos em `res/values/arrays.xml`.

---

## ⚙️ Tecnologias Utilizadas

- **Android Studio**: Ladybug 2024.2.2 (ou superior)
- **Gradle**: compatível com a versão do Android Studio
- **Linguagem**: Java
- **targetSdkVersion**: 35 (Android 15.0)
- **minSdkVersion**: 24 (Android 7.0)
- **ListView** com `Adapter` customizado
- **ArrayList** para armazenamento dos objetos
- **Toast** para exibição temporária de mensagens

---

## 🚧 Observações

- A tela principal agora é a `Activity` de listagem de hábitos, definida com as ações `MAIN` e `LAUNCHER` no `AndroidManifest.xml`.
- A `Activity` da Entrega 1 permanece no projeto, mas não é mais acessada diretamente pelo usuário.
- O uso de `ListView` permite fácil visualização e interação com os hábitos cadastrados.
- Ao clicar em um item da lista, é exibido um `Toast` contendo as informações relevantes do hábito.

---

## ▶️ Como Executar

Clone o repositório:
```bash
git clone https://github.com/AntonioFontess/DispositivosMoveis.git
