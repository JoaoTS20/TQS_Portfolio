# Task 1

- The project passed the defined quality for the Sonar-Way built-in set of measure-based, Boolean conditions.


# Issues

------------------------------------------------------------------------------------------------------------------------------
Bug
------------------------------------------------------------------------------------------------------------------------------     
### Problem Description
- Save and re-use this "Random".
- Using pseudorandom number generators (PRNGs) is security-sensitive.
- When software generates predictable values in a context requiring unpredictability, it may be possible for an attacker to guess the next value that will be generated, and use this guess to impersonate another user or access sensitive information.
### How to Solve
- Use a cryptographically strong random number generator (RNG) like "java.  security.SecureRandom" in place of this PRNG.
- Use the generated random values only once.
- You should not expose the generated random value. If you have to store it, make sure that the database or file is ||||secure.

        private Random rand = SecureRandom();  // SecureRandom is preferred to Random


------------------------------------------------------------------------------------------------------------------------------
Vulnerability
------------------------------------------------------------------------------------------------------------------------------     
### Problem Description 
- 0
### How to Solve
- 0

------------------------------------------------------------------------------------------------------------------------------
*Code Smell (major)*
------------------------------------------------------------------------------------------------------------------------------     

### Problem Description 
- Refactor the code in order to not assign to this loop counter from within the loop body.

- A for loop stop condition should test the loop counter against an invariant value.
- Stop conditions that are not invariant are slightly less efficient, as well as being difficult to understand and maintain, and likely lead to the introduction of errors in the future.

### How to Solve
    for (int i = 0; i < 10; i++) {...}

or

        int j=0;
        for (int i = 0; j < N_SELECTED_NUMBERS;i++) {
                ...
                j++;

------------------------------------------------------------------------------------------------------------------------------
### Problem Description
- Remove this unused method parameter "subset".
- Unused parameters are misleading. Whatever the values passed to such parameters, the behavior will be the same.

### How to Solve
- Remove the unused parameter "subset" (not done because it's used in the tests)

------------------------------------------------------------------------------------------------------------------------------
### Problem Description 
- Replace this use of System.out or System.err by a logger.

- When logging a message there are several important requirements which must be fulfilled:
    - The user must be able to easily retrieve the logs
    - The format of all logged message must be uniform to allow the user to easily read the log
    - Logged data must actually be recorded
    - Sensitive data must only be logged securely
    - If a program directly writes to the standard outputs, there is absolutely no way to comply with those requirements. That's why defining and using a dedicated logger is highly recommended.

### How to Solve
- Use
  
      Logger logger = Logger.getLogger(DemoMain.class.getName());
      logger.log(); 
------------------------------------------------------------------------------------------------------------------------------


# Task 2 

---------------
Technical Debt 
---------------
- a)
  - *2h 22min*
  - The estimated time required to fix all Maintainability Issues / code smells
  - Check Images Folder Task 2
    
- b)
  - See Project in folder Task 1
  
- c)
  - "Uncovered"
    - Lines: 40
    - Conditions: 14
  - Check Images Folder Task 2
    





--------------
# Task 3
    
    Metric	                    Operator	            Value	
    Code Smells	            is greater than	    50		Apesar de o objetivo ser o funcionamento não é aconselhável ter um número demasiado grande de code smells ao longo do projeto
    Coverage	            is less than	    75.0%	É essencial garantir que grande parte do código é testado.	
    Critical Issues	            is greater than	    2	        Problemas críticos podem existir ao longo do desenvolvimento mas não mais de 2 para ser rapidamente resolvidos em tempo útil 	
    Maintainability Rating	    is worse than	    B		Apesar de não existir ideia de manter o projeto a longo prazo é bom para o desenvolvimento o código ser fácil de atualizar
    Security Rating	            is worse than	    B		Como o Projeto utiliza contas com dados individuais como horários é importante garantir a segurança dos mesmos de forma a obter um funcionamento sem problemas 

- Check Images folder Task 3

# Task 4 

- Check Images folder Task 4

