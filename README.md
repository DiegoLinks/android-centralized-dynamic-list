# **Centralized Dynamic List**

_(Text in English followed by the translated text in Portuguese.
Texto em inglês seguido do texto traduzdio em português.)_

A set of custom components created to solve the problem of creating small dynamic lists that need to have elements centered in the available space, even with different quantities and sizes, in Android applications using XML.

![Design sem nome](https://github.com/DiegoLinks/android-centralized-dynamic-list/assets/36086232/ccb09a7a-aa12-4018-8cbf-b2a19563df1d)

The base code is designed to create dynamic lists ranging from 1 to 6 items with different configurations. However, the code can be combined with a RecyclerView to handle larger lists that could range from 0 to N.

Example of basic implementation:

```kotlin
// Here you reference the view, as you would with any other view
// In this case, we use data binding, but it could be done in the classic way with "val centralizedList = findViewById(R.id.centralized_list)"
val centralizedList = binding?.centralizedList ?: return

val list = medalList // A list with the items to be displayed

centralizedList.setItems(list) // Using the setItems method to add a list to the view
```

It is possible to dynamically create and modify the list during execution, as shown in the example app code. The source code is also open for modification according to specific needs. The source code itself has variations of the component, as can be seen in the examples below:

![Design sem nome (1)](https://github.com/DiegoLinks/android-centralized-dynamic-list/assets/36086232/a572622f-1ebf-4442-8691-ef8238de2476)

## **Dynamic Bottom Navigation**

Also included in the code is a feature using the same logic to build a dynamic Bottom Navigation. The code can be copied and used freely. It also serves as one more idea of the multiple possible implementations where this structure can be applied.

![Design sem nome (2)](https://github.com/DiegoLinks/android-centralized-dynamic-list/assets/36086232/5d30fe5d-f747-459b-bd99-a1a4903444a7)

_Agora em Português!_

# **Centralized Dynamic List**

Um conjunto de componentes personalizados criados para resolver o problema de criar pequenas listas dinâmicas que precisam ter os elementos centralizados no espaço disponível mesmo com quantidades e tamanhos diferentes em aplicativos android com XML.

![Design sem nome](https://github.com/DiegoLinks/android-centralized-dynamic-list/assets/36086232/ccb09a7a-aa12-4018-8cbf-b2a19563df1d)

O código base é feito para criar listas dinâmicas de 1 a 6 itens com diferentes configurações, porém o código pode ser combinado com um RecyclerView para trabalhar com listas maiores que poderiam ir de 0 a N. 

Exemplo de implementação básica:

```kotlin
//Aqui você faz a referência a view, como faria com qualquer outra view
//Nesse caso se usa databing, mas poderia ser feito do jeito clássico com “val centralizedList = findViewById(R.id.centralized_list)”
val centralizedList = binding?.centralizedList ?: return

val list = medalList //Uma lista com os itens a serem exibidos

centralizedList.setItems(list)//Com a view criada usasse o método setItems para adicionar uma lista
```

É possível criar de forma dinâmica para alterar a lista durante a execução, como está disponibilizado no código do aplicativo de exemplo.

O código também está aberto para que seja modificado de acordo com as necessidades. O próprio código fonte possui variações do componente, como é possível ver nos exemplos abaixo:

![Design sem nome (1)](https://github.com/DiegoLinks/android-centralized-dynamic-list/assets/36086232/a572622f-1ebf-4442-8691-ef8238de2476)

## **Dynamic Bottom Navigation**

Também está incluído no código uma feature usando a mesma lógica para construir um Bottom Navigation dinâmico, o código pode ser copiado e usado livremente. E serve também com mais uma ideia das múltiplas implementações possíveis onde essa estrutura pode ser aplicada. 

![Design sem nome (2)](https://github.com/DiegoLinks/android-centralized-dynamic-list/assets/36086232/5d30fe5d-f747-459b-bd99-a1a4903444a7)

_É sempre bom ter informação disponível na nossa língua! Mas de qualquer forma... estude inglês my friend._

