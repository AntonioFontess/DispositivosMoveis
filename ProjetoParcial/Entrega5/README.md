# 📱 Controle de Hábitos — Entrega 5

Este é o projeto atualizado do aplicativo **Controle de Hábitos**, desenvolvido para a disciplina de **Dispositivos Móveis**, como parte da **Entrega 5**.  
Esta versão é uma **continuação direta da Entrega 4**, com suporte à **internacionalização em dois idiomas** e **configurações persistentes via SharedPreferences**.

---

## 🎯 Objetivo

Adicionar funcionalidades de **configuração e personalização** do app, permitindo que o usuário escolha como prefere interagir com a aplicação.  
As configurações são salvas localmente no dispositivo por meio de **SharedPreferences** e aplicadas automaticamente em execuções futuras.  
Além disso, o app agora oferece suporte a dois idiomas: **Inglês (padrão)** e **Português do Brasil**.

---

## ✅ Funcionalidades da Entrega 5

### 🌍 Internacionalização (i18n)

- Suporte completo a **dois idiomas**:
  - 🇺🇸 Inglês (padrão)
  - 🇧🇷 Português do Brasil

- Todos os textos fixos da interface foram extraídos para arquivos `strings.xml` nas pastas:
  - `res/values/strings.xml` (inglês)
  - `res/values-pt/strings.xml` (português)

- Textos traduzidos incluem:
  - Labels, botões, menus, títulos
  - Mensagens de Toast
  - Textos de AlertDialogs

---

### ⚙️ Configurações com SharedPreferences

Foi incluída uma nova tela de **configurações** com funcionalidades personalizáveis, entre elas:

- 🔠 **Ordenação dos itens da lista** (ex: por nome, por prioridade)
- ✍️ **Sugerir preenchimento automático no cadastro** (sim/não)
- 🌙 **Alternância entre modo claro e modo escuro**
- ⭐ **Exibir funcionalidades mais usadas em destaque**

As opções são armazenadas com `SharedPreferences`, garantindo que:

- O estado do app persista mesmo após fechar
- As escolhas do usuário sejam respeitadas ao reabrir o app

---


---

## 🛠️ Tecnologias Utilizadas

- **Android Studio**: Ladybug 2024.2.2 (ou superior)
- **Linguagem**: Java
- **Gradle**: versão compatível com o Android Studio utilizado
- `targetSdkVersion`: **35** (Android 15.0)
- `minSdkVersion`: **24** (Android 7.0)
- **SharedPreferences** para persistência de configurações
- **Internacionalização (i18n)** com `strings.xml` traduzidos
- Modo claro e escuro com tema alternável
- Menu de configurações customizado

---

## 🚧 Observações

- A mudança de idioma segue automaticamente o idioma configurado no sistema Android.
- O modo escuro/claro é aplicado com base nas preferências salvas.
- O comportamento da listagem e do cadastro é ajustado dinamicamente conforme as configurações escolhidas.
- Todas as configurações são salvas localmente e recuperadas automaticamente ao abrir o app.

---

## ▶️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/AntonioFontess/DispositivosMoveis.git

