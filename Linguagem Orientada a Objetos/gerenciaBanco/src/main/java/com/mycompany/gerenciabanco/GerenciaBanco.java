/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner;


class contaBancaria{
    public String nome;
    public String sobrenome;
    public String cpf;
    public double saldo;
    
    public contaBancaria (String nome, String sobrenome, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }
    
    public double consultarSaldo(){
        return saldo;
    }
    
    public void depositar(double valor){
        saldo += valor;
        System.out.println("Deposito de R$" + valor + " realizado com sucesso.");
    }
    
    public void sacar (double valor){
        if (saldo>=valor){
            saldo-=valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insufuciente para realizar o saque.");
        }
    }
    
    public void exibirMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n------Menu----");
            System.out.println("1. Consultar o saldo.");
            System.out.println("2. Realizar o deposito.");
            System.out.println("3. Realizar o saque.");
            System.out.println("4. Encerrar.");
            System.out.println("Escolha uma opcao:");
            opcao = scanner.nextInt();
            
            switch(opcao){
                case 1:
                    System.out.println("Saldo: R$ " + consultarSaldo());
                    break;
                    
                    case 2:
                    System.out.println("Digite o valor do deposito:");
                    double valorDeposito = scanner.nextDouble();
                    depositar(valorDeposito);
                    break;
                    
                    case 3:
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = scanner.nextDouble();
                    sacar(valorSaque);
                    break;
                    
                    case 4:
                    System.out.println("Encerrando...");
                    break;
                    default:
                        System.out.println("Opção Invalida.");
            }
            
            
        } while (opcao!=4);
        
        scanner.close();
    }
    
}

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        
        System.out.println("Seja Bem Vindo ao Sistema Bancario.");
        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite seu sobrenome:");
        String sobrenome = scanner.nextLine();
        System.out.println("Digite seu cpf:");
        String cpf = scanner.nextLine();
        
        contaBancaria conta = new contaBancaria(nome,sobrenome,cpf);
        
        conta.exibirMenu();
        
        System.out.println("Obrigado por utilizar nosso servico!");
        scanner.close();
    }
}
