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

## 🗂️ Estrutura de Pastas

