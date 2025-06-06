
Cada pasta representa uma entrega específica do projeto, contendo os arquivos do Android Studio e um `README.md` individual com explicações detalhadas.

---

## 📚 Tema Geral

O aplicativo tem como objetivo ajudar o usuário a registrar e acompanhar hábitos saudáveis, como beber água, ler, praticar exercícios e organizar rotinas.  
A evolução do app incorpora recursos de cadastro, listagem, personalização, persistência e suporte a múltiplos idiomas.

---

## 🔄 Evolução das Entregas

### ✅ Entrega 1
- Tela de cadastro de hábitos com validação e exibição via `Toast`.
- Utilização de `EditText`, `RadioButton`, `Spinner`, `CheckBox`, `ScrollView`.

### ✅ Entrega 2
- Criação da entidade `Hábito`.
- Listagem de hábitos carregados via `arrays.xml` e exibidos com `ListView` e `Adapter` customizado.
- Definição da tela de listagem como principal (`Launcher`).

### ✅ Entrega 3
- Inclusão de uma `Activity` de autoria com dados do aluno.
- Comunicação entre Activities com `startActivityForResult`.
- Cadastro adicionando hábitos à lista dinamicamente.

### ✅ Entrega 4
- Substituição de `Buttons` por `MenuItems` nos menus de opções e menus contextuais.
- Funções de editar e excluir itens com `notifyDataSetChanged`.
- Botões "Up" nas telas secundárias para navegação fluida.

### ✅ Entrega 5
- Suporte à **internacionalização** (`pt-BR` e `en`).
- **SharedPreferences** para persistência de configurações como:
  - Ordenação da lista
  - Sugestão de preenchimento no cadastro
  - Modo Noturno
- Separação completa de textos com arquivos `strings.xml` por idioma.

---

## ⚙️ Tecnologias Utilizadas

- **Android Studio**: Ladybug 2024.2.2 ou superior
- **Gradle**: compatível com a versão do Android Studio
- **Linguagem**: Java
- **targetSdkVersion**: 35 (Android 15.0)
- **minSdkVersion**: 24 (Android 7.0)

---

## 👨‍💻 Autor

- **Nome**: Antonio Fontes  
- **Curso**: Engenharia de Computação — UTFPR  
- **Email**: antoniofontes@email.com

---

## ▶️ Como Executar

Clone o repositório:

```bash
git clone https://github.com/AntonioFontess/DispositivosMoveis.git
