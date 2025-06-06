# 📱 Controle de Hábitos — Entrega 4

Este é o projeto atualizado do aplicativo **Controle de Hábitos**, desenvolvido para a disciplina de **Dispositivos Móveis**, como parte da **Entrega 4**.  
Esta versão é uma **continuação direta da Entrega 3**, com melhorias na navegação, organização e interações com o usuário através de menus de opções e menus de ação contextual.

---

## 🎯 Objetivo

Substituir os botões tradicionais por menus (`MenuItem`) organizados em menus de opções e menus contextuais.  
Adotar práticas modernas de navegação com **botões Up** na barra da aplicação, organização por Activities reutilizáveis (cadastro e edição), e uma experiência de usuário mais próxima de um aplicativo real.

---

## ✅ Funcionalidades da Entrega 4

### 🔷 Na tela principal (Listagem)

- **Remoção dos botões "Adicionar" e "Sobre"**
- Inclusão de um **menu de opções** com:
  - `Adicionar` (com ícone): abre a tela de cadastro via `startActivityForResult`
  - `Sobre`: abre a tela com informações de autoria do app

- **Menu de ação contextual (ao manter o dedo pressionado em um item):**
  - `Editar` (com ícone): abre a tela de cadastro **com dados preenchidos** para edição
  - `Excluir` (com ícone): remove o item do `ArrayList` e atualiza a tela com `notifyDataSetChanged()`

- **Tratamento completo no `onActivityResult`**:
  - Verifica se um novo hábito foi adicionado ou se um item foi editado
  - Atualiza a entidade correspondente no `ArrayList`
  - Chama `notifyDataSetChanged()` para atualizar a lista

---

### 🟢 Na tela de Cadastro

- A Activity agora funciona tanto para **cadastro** quanto para **edição**
  - Quando aberta com dados extras, os campos são preenchidos para edição
  - Ao salvar, devolve os dados com `setResult(RESULT_OK, intent)`

- Substituição dos botões por um **menu de opções** com:
  - `Salvar`: valida e envia os dados de volta para a tela de listagem
  - `Limpar`: limpa todos os campos e exibe `Toast`

- **Botão Up na barra de título**:
  - Cancela o cadastro/edição e volta para a tela de listagem

---

### 🟣 Na tela de Autoria

- Incluído **botão Up** na barra da aplicação para retornar à tela principal

---

## 🗂️ Entidades Utilizadas

### 📌 Hábito

| Campo       | Tipo     | Descrição                        |
|-------------|----------|----------------------------------|
| nome        | String   | Nome do hábito                   |
| categoria   | String   | Ex: Saúde, Leitura, Produtividade|
| nivel       | int      | Dificuldade, prioridade ou ordem |
| descricao   | String   | Descrição do hábito              |

---

## ⚙️ Tecnologias Utilizadas

- **Android Studio**: Ladybug 2024.2.2 (ou superior)
- **Linguagem**: Java
- **Gradle**: compatível com o Android Studio utilizado
- `targetSdkVersion`: **35** (Android 15.0)
- `minSdkVersion`: **24** (Android 7.0)
- `ListView` com `Adapter` customizado
- `ArrayList` para dados dinâmicos
- `startActivityForResult` + `setResult` para comunicação entre telas
- `MenuInflater`, `ContextualActionMode`, `MenuItem` e `onCreateOptionsMenu`
- Botões **Up** usando suporte a ActionBar
- Temas com **barra de título ativa**, conforme documentado na aula "Troque o Tema para Exibir a Barra do Aplicativo"

---

## 🚧 Observações

- A experiência do usuário foi melhorada com navegação por menus.
- A tela de cadastro agora é **reutilizada** para cadastrar e editar hábitos.
- Os dados da lista são atualizados em tempo real ao voltar da Activity de cadastro.
- Todas as interações seguem os padrões modernos de interface do Android.

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/AntonioFontess/DispositivosMoveis.git
