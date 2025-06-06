# 📱 Dispositivos Móveis — Controle de Hábitos

Repositório com o desenvolvimento completo do aplicativo **Controle de Hábitos**, feito para a disciplina de **Dispositivos Móveis** da UTFPR.

O app permite que o usuário **registre, gerencie e acompanhe hábitos e atividades do dia a dia**, com foco em bem-estar e produtividade.

---

## 📂 Estrutura do Repositório

| Pasta         | Descrição                                                                 |
|---------------|---------------------------------------------------------------------------|
| `ProjetoParcial/` | Contém as entregas 1 a 5, com evolução incremental do projeto         |
| `ProjetoFinal/`   | Versão final do app com persistência via Room, AlertDialogs, i18n, etc |

---

## 📱 Funcionalidades do App

- Cadastro e edição de hábitos
- Listagem com Adapter customizado
- Relacionamento entre entidades com Room
- Persistência de dados locais (Room + SharedPreferences)
- Suporte a dois idiomas (🇺🇸 EN / 🇧🇷 PT-BR)
- Configurações personalizáveis
- Menus de opções e ação contextual
- AlertDialogs para confirmação de exclusão
- Uso de `DatePicker` com `LocalDate` adaptado por idioma
- Navegação com botão Up entre Activities

---

## 🧪 Tecnologias Utilizadas

- **Android Studio**: Ladybug 2024.2.2 ou superior
- **Linguagem**: Java
- **Room**, **LiveData**, **ViewModel**
- **SharedPreferences**
- **MenuInflater**, `startActivityForResult`, `AlertDialog`, `DatePicker`
- `minSdkVersion`: 24 • `targetSdkVersion`: 35

---

## 👨‍💻 Autor

- **Aluno**: Antonio Fontes  
- **Curso**: Engenharia de Computação — UTFPR  
- **Ano**: 2025

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/AntonioFontess/DispositivosMoveis.git
