Single Responsibility Principle (SRP):
1. Princípio usado para remover da classe de inicialização (App.java) o excesso de funções que a mesma possuía, dividindo as responsabilidades em outras classes nos módulos repository, menu, ui e service.
Open Closed Principle (OCP):
1. Aplicado nas classes de ItemMenu, que herdam de uma classe pai e permitem adicionar novas opções ao menu apenas criando uma nova classe, sem a necessidade de modificar a classe principal.
Liskov Substitution Principle (LSP):
1. Aplicado de forma que os itens de menu tenham obrigatoriamente que implementar o método executar(), estipulado pela classe pai, o que garante o resultado esperado para a continuidade do programa independente da subclasse utilizada.
Interface Segregation Principle (ISP):
1. Aplicado quando a classe pai ItemMenu.java define apenas o comportamento essencial que será usado por todas as classes que a implementam, evitando métodos desnecessários.
Dependency Inversion Principle (DIP):
1. Aplicado quando a classe App.java executa os métodos das classes de ItemMenu. A classe executa o método através de uma abstração, sem conhecer a sua implementação específica.
