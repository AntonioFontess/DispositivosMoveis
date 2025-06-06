# 📱 Controle de Hábitos — Entrega 3

Este é o projeto atualizado do aplicativo **Controle de Hábitos**, desenvolvido para a disciplina de **Dispositivos Móveis**, como parte da **Entrega 3**.  
Esta versão é uma **continuação direta da Entrega 2**, incluindo agora a adição dinâmica de hábitos e uma tela de autoria do aplicativo.

---

## 🎯 Objetivo

Expandir a aplicação para permitir que os hábitos exibidos na listagem principal sejam **cadastrados dinamicamente** por meio de um formulário.  
Também foi criada uma nova tela para exibir os **dados de autoria do app**, além de permitir a navegação entre as Activities já desenvolvidas.

---

## ✅ Funcionalidades da Entrega 3

- Nova `Activity` de **Autoria**, exibindo:
  - Nome do aluno
  - Curso
  - E-mail
  - Breve descrição do app
  - Logo e nome da UTFPR

- Atualização da `Activity` de **Listagem**:
  - **Botão "Adicionar"**: abre a Activity de cadastro esperando retorno com `startActivityForResult`.
  - **Botão "Sobre"**: abre a tela de autoria.
  - Agora a listagem **não usa arrays do resource**, mas sim os dados cadastrados dinamicamente.

- Na `Activity` de **Cadastro**:
  - Valida os dados e os retorna para a tela de listagem com `setResult(RESULT_OK, intent)`.

- Na `Activity` de **Listagem**:
  - Implementação do `onActivityResult` (ou equivalente moderno)
  - Recebe os dados, cria um novo objeto da entidade `Hábito`, adiciona ao `ArrayList` e atualiza a lista com `notifyDataSetChanged()`.

---

## 🗂️ Entidades Utilizadas

### 📌 Hábito

| Campo       | Tipo     | Descrição                        |
|-------------|----------|----------------------------------|
| nome        | String   | Nome do hábito                   |
| categoria   | String   | Ex: Saúde, Leitura, Produtividade|
| nivel       | int      | Ex: dificuldade ou prioridade    |
| descricao   | String   | Descrição do hábito              |

---

## ⚙️ Tecnologias Utilizadas

- **Android Studio**: Ladybug 2024.2.2 ou superior
- **Linguagem**: Java
- **Gradle**: compatível com o Android Studio utilizado
- `targetSdkVersion`: 35 (Android 15.0)
- `minSdkVersion`: 24 (Android 7.0)
- `ListView` + `Adapter` customizado
- `startActivityForResult()` e `setResult()` para comunicação entre Activities
- `notifyDataSetChanged()` para atualizar lista
- `Toast` para mensagens rápidas
- Temas e estilos para exibir a **Barra de Aplicação**

---

## 🚧 Observações

- A tela de **cadastro** permanece no projeto e agora retorna dados para a tela principal.
- O botão **"Sobre"** leva à tela de autoria do app com dados do aluno.
- A listagem agora só exibe **hábitos cadastrados manualmente**.
- A aplicação está adaptada para exibir a barra superior com tema claro ou escuro conforme orientações da Google.

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/AntonioFontess/DispositivosMoveis.git
