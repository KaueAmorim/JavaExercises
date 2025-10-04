# **Resumo Java**

## **Tópicos Principais: Fundamentos da Orientação a Objetos**

### **1. Classe, Objeto e Encapsulamento**

#### **Classe: O Molde**

Uma **classe** é um "molde" ou "planta" para criar objetos. Ela define um conjunto de **atributos** (dados/características) e **métodos** (comportamentos/ações) que os objetos desse tipo terão.

```java
public class Funcionario {
    // Atributos (características)
    private String nome;
    private int anoAdmissao;
    private double salario;

    // Métodos (comportamentos)
    public void promover(double aumento) {
        this.salario += aumento;
    }
}
```

#### **Objeto: A Instância**

Um **objeto** é a instância concreta de uma classe, criada a partir do "molde". Cada objeto possui seus próprios valores para os atributos definidos na classe.

```java
// Criando dois objetos (instâncias) da classe Funcionario
Funcionario f1 = new Funcionario();
Funcionario f2 = new Funcionario();
```

#### **`this`: A Referência ao Próprio Objeto**

A palavra-chave `this` é usada dentro de um método para se referir ao objeto atual que está executando aquele método. É útil para desambiguar entre atributos da classe e parâmetros de métodos com o mesmo nome.

#### **Encapsulamento: Protegendo os Dados com `get` e `set`**

O encapsulamento é o princípio de proteger os atributos de uma classe, tornando-os `private` e fornecendo acesso controlado através de métodos públicos (`getters` e `setters`).

  - **Objetivo:** Garantir a integridade dos dados e ocultar a complexidade interna do objeto.
  - **`get` (Acessor):** Recupera o valor de um atributo. Para `boolean`, usa-se o prefixo `is` (ex: `isAtivo()`).
  - **`set` (Modificador):** Altera o valor de um atributo, permitindo a inclusão de regras de validação.

<!-- end list -->

```java
public class Funcionario {
    private double salario;

    // Getter: Apenas retorna o valor
    public double getSalario() {
        return this.salario;
    }

    // Setter: Altera o valor com validação
    public void setSalario(double salario) {
        if (salario > 0) { // Regra de validação
            this.salario = salario;
        } else {
            System.out.println("Erro: O salário deve ser positivo.");
        }
    }
}
```

### **2. Construtores: Inicializando Objetos**

O **construtor** é um método especial chamado automaticamente quando um objeto é criado (`new`). Sua função é inicializar os atributos do objeto.

  - **Características:**
      - Tem o mesmo nome da classe.
      - Não possui tipo de retorno (nem mesmo `void`).
      - **Construtor Padrão:** Se nenhum construtor for definido, o Java cria um automaticamente (vazio e sem parâmetros).

#### **Sobrecarga de Construtores**

É a prática de criar múltiplos construtores na mesma classe, cada um com uma lista de parâmetros diferente. Isso oferece flexibilidade para criar objetos de várias maneiras.

  - **Dica de boa prática:** Use `this()` para chamar um construtor a partir de outro, evitando repetição de código. A chamada a `this()` deve ser a primeira instrução.

<!-- end list -->

```java
public class Funcionario {
    private String nome;
    private double salario;

    // Construtor 1: Recebe nome e salário
    public Funcionario(String nome, double salario) {
        this.setNome(nome); // Usando setters para validação
        this.setSalario(salario);
    }

    // Construtor 2: Recebe apenas o nome (assume salário inicial 0)
    public Funcionario(String nome) {
        this(nome, 0.0); // Chama o primeiro construtor
    }
}
```

### **3. Método `toString()`: Representação em Texto**

Todo objeto em Java possui um método `toString()`, herdado da superclasse `Object`. Por padrão, ele retorna uma representação textual pouco útil (ex: `Funcionario@53d8d10a`).

  - **Utilidade:** Sobrescrever (`@Override`) o `toString()` é uma excelente prática para retornar uma string informativa sobre o estado do objeto, facilitando a depuração e a exibição de dados.

<!-- end list -->

```java
@Override
public String toString() {
    return String.format("Funcionário[Nome=%s, Salário=R$%.2f]",
                         this.nome, this.salario);
}

// System.out.println(f1);
// Saída: Funcionário[Nome=João, Salário=R$2550,00]
```

-----

## **Tópicos Principais: Relacionamentos e Reutilização**

### **4. Relações entre Classes**

#### **Composição ("Tem-um")**

Ocorre quando uma classe possui um atributo que é de outro tipo de classe. Cria uma relação forte onde um objeto "contém" outro.

  - **Relação:** "Uma `Pessoa` **tem-um** `Endereco`."
  - **Dependência:** O objeto "parte" (Endereco) geralmente não faz sentido sem o objeto "todo" (Pessoa).

<!-- end list -->

```java
public class Pessoa {
    private String nome;
    private Endereco endereco; // Composição: Pessoa "tem-um" Endereco
}
```

#### **Herança ("É-um")**

Permite que uma classe (subclasse) herde atributos e métodos de outra classe (superclasse). É usada para criar especializações e reutilizar código.

  - **Relação:** "Um `Carro` **é-um** `Veiculo`."
  - **Palavras-chave:**
      - `extends`: Define que uma classe herda de outra.
      - `super`: Usado na subclasse para acessar membros (construtor, métodos) da superclasse.
      - `@Override`: Anotação que indica a sobrescrita de um método da superclasse.
  - **Modificador `protected`:** Torna um membro da superclasse visível para suas subclasses, mas não para o resto do mundo.

<!-- end list -->

```java
// Superclasse
public class Veiculo {
    protected String marca;

    public Veiculo(String marca) { // Construtor da superclasse
        this.marca = marca;
    }

    public void mover() {
        System.out.println("Veículo se movendo.");
    }
}

// Subclasse
public class Carro extends Veiculo {
    private int numPortas;

    public Carro(String marca, int numPortas) {
        super(marca); // OBRIGATÓRIO: Chama o construtor da superclasse
        this.numPortas = numPortas;
    }

    @Override // Sobrescrevendo o comportamento
    public void mover() {
        System.out.println("Carro acelerando...");
    }
}
```

  - **Método `final`:** Um método declarado como `final` não pode ser sobrescrito (`@Override`) por subclasses.

### **5. Polimorfismo: "Muitas Formas"**

Polimorfismo é a capacidade de um objeto ser referenciado de múltiplas formas. Em termos práticos, permite que objetos de diferentes classes respondam à mesma chamada de método de maneiras específicas.

#### **Tipos Principais**

1.  **Sobrescrita (Inclusão / *Runtime*):** É o pilar do polimorfismo. Uma variável do tipo da superclasse pode referenciar um objeto de qualquer subclasse. O método executado será o da subclasse (o mais específico).

    ```java
    Veiculo meuVeiculo = new Carro("Fiat", 4);
    meuVeiculo.mover(); // Executa o mover() de Carro: "Carro acelerando..."
    ```

2.  **Sobrecarga (*Overloading* / *Compile-time*):** Ocorre quando múltiplos métodos na mesma classe têm o mesmo nome, mas **assinaturas diferentes** (lista de parâmetros diferente).

    ```java
    public class Calculadora {
        public int somar(int a, int b) { return a + b; }
        public double somar(double a, double b) { return a + b; }
    }
    ```

#### **Casting (Coerção)**

  - **Upcast:** Converter um objeto de uma subclasse para uma superclasse. É seguro e implícito.
    `Veiculo v = new Carro();`
  - **Downcast:** Converter um objeto de uma superclasse para uma subclasse. É arriscado e exige verificação com `instanceof`.
    ```java
    if (v instanceof Carro) {
        Carro c = (Carro) v; // Downcast explícito
        c.abrirPorta();
    }
    ```

| Comparação | Sobrescrita (`@Override`) | Sobrecarga (`Overloading`) |
| :--- | :--- | :--- |
| **Onde ocorre?** | Em classes diferentes (relação de herança) | Na mesma classe |
| **Assinatura?** | Deve ser a mesma | Deve ser diferente |
| **Relação?** | Polimorfismo em tempo de execução | Polimorfismo em tempo de compilação |
| **Exemplo** | `veiculo.mover()` | `calc.somar(1, 2)` vs `calc.somar(1.5, 2.5)`|

-----

## **Tópicos Principais: Abstração e Contratos**

### **6. Classe Abstrata**

Uma classe declarada como `abstract` que **não pode ser instanciada**. Serve como um modelo base para outras classes, podendo conter:

  - **Métodos concretos:** Com implementação, que são herdados normalmente.

  - **Métodos abstratos:** Sem implementação (`{}`), que **obrigam** as subclasses concretas a implementá-los.

  - **Quando usar?** Quando você tem um conceito base com comportamentos comuns e outros que devem ser definidos por cada subclasse.

<!-- end list -->

```java
public abstract class Forma {
    // Método concreto, herdado por todos
    public String getNome() {
        return "Forma genérica";
    }

    // Método abstrato, OBRIGA a implementação nas subclasses
    public abstract double calcularArea();
}

public class Quadrado extends Forma {
    private double lado;
    @Override
    public double calcularArea() { // Implementação obrigatória
        return lado * lado;
    }
}
```

### **7. Interface**

Uma interface é um "contrato" que define um conjunto de métodos que uma classe **deve** implementar. Ela garante que certas classes terão determinados comportamentos, sem se importar com a forma como são implementados.

  - **Características:**
      - Usa a palavra-chave `implements`.
      - **Não pode** ter atributos de instância ou construtores.
      - Todos os métodos são `public` e `abstract` por padrão.
      - Uma classe pode implementar **múltiplas interfaces**, o que resolve a limitação da herança simples do Java.

<!-- end list -->

```java
// O contrato
public interface Autenticavel {
    boolean autenticar(String senha);
}

// A classe que assina o contrato
public class Gerente extends Funcionario implements Autenticavel {
    private String senha;

    @Override
    public boolean autenticar(String senha) { // Implementação obrigatória
        return this.senha.equals(senha);
    }
}
```

| Comparação | Classe Abstrata | Interface |
| :--- | :--- | :--- |
| **Propósito** | Fornecer um "molde" base com código reutilizável | Definir um "contrato" de comportamentos |
| **Herança** | `extends` (só pode herdar de uma) | `implements` (pode implementar várias) |
| **Membros** | Pode ter atributos e métodos concretos | Apenas assinaturas de métodos e constantes |
| **Construtor**| Possui construtor (para ser chamado com `super`) | Não possui construtor |
| **Quando usar?** | Relação "É-um" forte, com código em comum | Relação "É-capaz-de", para definir habilidades |

-----

## **Tópicos Principais: Estruturas de Dados**

### **8. Collections Framework**

Um conjunto de classes e interfaces para armazenar e manipular grupos de objetos de forma eficiente. Elas são dinâmicas (tamanho flexível), ao contrário de arrays.

  - **Classes Wrapper:** Coleções não aceitam tipos primitivos (`int`, `double`). É necessário usar suas classes "embrulho" (`Integer`, `Double`). O Java faz a conversão automaticamente (autoboxing/unboxing).

#### **Interface `List`: Coleção Ordenada**

Permite elementos duplicados e os mantém na ordem de inserção. O acesso aos elementos é feito por um índice.

| Implementação | Estrutura Interna | Quando Usar? |
| :--- | :--- | :--- |
| **`ArrayList`** | Array dinâmico | Acesso rápido a elementos por índice (`get`). Bom para listas que são mais lidas do que modificadas. |
| **`LinkedList`**| Lista duplamente encadeada | Inserções e remoções rápidas no início/meio/fim da lista. Acesso por índice é lento. |

**Iteração (percorrer a lista):**

```java
// Usando for-each (mais comum e simples)
for (String nome : minhaLista) {
    System.out.println(nome);
}
```

#### **Interface `Set`: Coleção Única**

**Não permite** elementos duplicados. Ideal para armazenar elementos únicos sem se preocupar com a ordem.

| Implementação | Ordem | Performance |
| :--- | :--- | :--- |
| **`HashSet`** | Nenhuma ordem garantida | **Muito rápida** (`O(1)` em média) para adicionar, remover e verificar se contém um elemento. Usa `hashCode()`. |
| **`TreeSet`** | Elementos **ordenados** (naturalmente ou por `Comparator`) | Rápida (`O(log n)`), mas mais lenta que `HashSet` por precisar manter a ordem. |

```java
Set<String> emails = new HashSet<>();
emails.add("contato@email.com");
emails.add("suporte@email.com");
emails.add("contato@email.com"); // Este será ignorado, pois já existe.

System.out.println(emails.size()); // Saída: 2
```
