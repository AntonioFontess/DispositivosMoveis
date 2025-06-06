# 📱 Controle de Hábitos — Projeto Final

Este é o projeto **final** do aplicativo **Controle de Hábitos**, desenvolvido para a disciplina de **Dispositivos Móveis** da UTFPR.  
Esta versão consolida tudo que foi desenvolvido nas Entregas 1 a 5, incorporando persistência de dados com **Room**, uso de **AlertDialogs**, suporte a **dois idiomas**, e **configurações salvas via SharedPreferences**.

---

## 🎯 Tema do Projeto

O aplicativo tem como objetivo **auxiliar o usuário a cadastrar, registrar e acompanhar hábitos e atividades saudáveis** do dia a dia, como leitura, exercícios e bem-estar.  
Nesta versão, os dados são **persistidos localmente com banco de dados Room**, permitindo cadastro de hábitos e categorias com relacionamento entre eles.

---

## ✅ Funcionalidades Implementadas

- 📂 **Persistência de dados com Room**
- 🔗 **Relacionamento entre entidades** (Habito possui uma Categoria)
- 📅 **Uso de `LocalDate` com DatePicker**, com conversão para String conforme o idioma
- 📝 **Cadastro, edição e remoção de dados** com AlertDialog de confirmação para exclusões
- 👁️ **Listagem de dados** com `Adapter` customizado
- 🌐 **Suporte a dois idiomas**:
  - 🇺🇸 Inglês (padrão)
  - 🇧🇷 Português (opcional)
- ⚙️ **SharedPreferences** para configurações:
  - Modo escuro/claro
  - Sugestões de preenchimento
  - Ordenação da lista
- 📑 **Menus com ícones**:
  - Menu de opções (`MenuItem` com `showAsAction="ifRoom"`)
  - Menu de ação contextual (edição e exclusão via clique longo)
- 🔼 **Botões Up** nas Activities secundárias
- ℹ️ **Tela de Autoria** com dados do aluno e descrição do aplicativo

---

## 🧩 Entidades Criadas

### 📌 `Habito`

| Campo       | Tipo       | Descrição                         |
|-------------|------------|-----------------------------------|
| id          | int (PK)   | Identificador do hábito           |
| nome        | String     | Nome do hábito                    |
| descricao   | String     | Descrição                        |
| dataInicio  | LocalDate  | Data inicial do hábito            |
| idCategoria | int (FK)   | Referência à categoria associada  |

### 📌 `Categoria`

| Campo       | Tipo     | Descrição                      |
|-------------|----------|--------------------------------|
| id          | int (PK) | Identificador da categoria     |
| nome        | String   | Nome da categoria              |

> As duas entidades são persistidas com Room, com anotação `@Entity`, `@ForeignKey` e `@TypeConverter` para LocalDate.

---

## 📱 Telas do Aplicativo

- **Tela de listagem de hábitos** com menu de opções (adicionar/sobre)
- **Tela de listagem de categorias**
- **Tela de cadastro/edição de hábito**, com `DatePicker` e `Spinner` para selecionar a categoria
- **Tela de cadastro de categoria**
- **Tela de configurações** com opções personalizáveis persistidas
- **Tela de autoria** com informações do aluno
- **AlertDialog** para confirmação de exclusão

---

## 🛠️ Tecnologias Utilizadas

- **Android Studio**: Ladybug 2024.2.2
- **Linguagem**: Java
- `Room` + `LiveData` + `ViewModel`
- `SharedPreferences`
- `AlertDialog`
- `DatePickerDialog`
- `ListView` + `Adapter` customizado
- `MenuInflater`, `onCreateOptionsMenu`, `ContextMenu`
- `Intent` + `startActivityForResult`
- `TypeConverter` para `LocalDate`
- `strings.xml` com suporte a múltiplos idiomas (`res/values/` e `res/values-pt/`)

---

## 🌍 Suporte a Idiomas

O aplicativo foi internacionalizado com suporte a:

- 🇺🇸 Inglês (default)
- 🇧🇷 Português (res/values-pt/)

> Todos os textos, toasts e menus foram traduzidos, e `LocalDate` é formatado conforme o idioma atual do sistema.

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/AntonioFontess/DispositivosMoveis.git
