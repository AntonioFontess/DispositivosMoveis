# Dispositivos-M-veis
# 📱 Controle de Hábitos — Entrega 1

Este é o projeto inicial do aplicativo **Controle de Hábitos**, desenvolvido para a disciplina de **Dispositivos Móveis**, como parte da **Entrega 1**.

---

## 🎯 Tema

O aplicativo tem como objetivo ajudar o usuário a acompanhar e manter hábitos saudáveis, como beber água, ler um livro ou praticar exercícios. Com uma interface simples, o app permite registrar hábitos, marcar quando forem concluídos e acompanhar o progresso diário.

---

## ✅ Funcionalidades da Entrega 1

A entrega consiste na criação de um formulário de cadastro com os seguintes requisitos:

- **TextView**: para exibição de rótulos dos campos;
- **EditText**: pelo menos 1 campo para entrada de texto (ex: nome do hábito);
- **RadioGroup + RadioButtons**: para selecionar a frequência desejada;
- **CheckBox**: para marcar se o hábito deve gerar notificações;
- **Spinner**: com opções de categorias (ex: saúde, leitura, produtividade);
- **Botões**:
  - **Salvar**: valida os campos preenchidos, exibe os dados via Toast e mostra erro caso algo esteja vazio ou inválido;
  - **Limpar**: apaga o conteúdo de todos os campos e mostra um Toast informando a ação;
- **ScrollView**: usado para permitir rolagem em dispositivos com telas menores.

---

## 🗂️ Entidades Previstas

### 📌 Hábito

| Campo      | Tipo    |
|------------|---------|
| `id`       | Inteiro |
| `nome`     | String  |
| `frequência` | String |

### 📌 Registro de Hábito

| Campo         | Tipo     |
|---------------|----------|
| `id`          | Inteiro  |
| `id_hábito`   | Inteiro  *(chave estrangeira)* |
| `data`        | Date     |
| `status`      | Boolean  |

---

## ⚙️ Tecnologias Utilizadas

- **Android Studio**: Ladybug 2024.2.2 (ou superior)
- **Gradle**: versão compatível com o Android Studio utilizado
- **Linguagem**: Java
- **targetSdkVersion**: 35 (Android 15.0)
- **minSdkVersion**: 24 (Android 7.0)
- **ScrollView** para adaptar o formulário à tela do dispositivo
- **Toast** para exibição provisória de mensagens

---

## 🚧 Observações

- Mensagens via `Toast` são temporárias. Em futuras entregas, os dados serão exibidos em uma **tela de listagem**.
- A exibição pode ser limitada a duas linhas a partir do Android 12 (API 31).
- O foco retorna ao primeiro campo vazio durante validação, se possível.

---

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/AntonioFontess/Dispositivos-Moveis.git
