package ub2.Lösung// Author: C. Stamm

import java.io.*;

public class StackComputer {
    Stack<Integer> m_stack = new Stack<Integer>();
    boolean m_ok = true;
    char m_c;
    
    int ziffer() {
        if (m_ok && m_c >= '0' && m_c <= '9') {
            return m_c - '0';
        } else {
            m_ok = false;
            return 0;
        }
    }
    
    void spaces() {
        while(m_c == ' ' || m_c == 13) {
            input();
        }
    }
    
    int zahl() {
        spaces();
        int z = 0, v = ziffer();
        if (!m_ok) return -1;
        
        while (m_ok) {
            z = 10*z + v;
            input();
            v = ziffer();
        }
        m_ok = true;
        return z;
    }
    
    int operation() {
        int z1, z2;
        spaces();
        switch(m_c) {
            case '+':
                if (m_stack.isEmpty())  { m_ok = false; return 0; }
                z1 = m_stack.pop();
                if (m_stack.isEmpty())  { m_ok = false; return 0; }
                z2 = m_stack.pop();
                input();
                return z1 + z2;
            case '-':
                if (m_stack.isEmpty())  { m_ok = false; return 0; }
                z1 = m_stack.pop();
                if (m_stack.isEmpty())  { m_ok = false; return 0; }
                z2 = m_stack.pop();
                input();
                return z2 - z1;
            case '*':
                if (m_stack.isEmpty())  { m_ok = false; return 0; }
                z1 = m_stack.pop();
                if (m_stack.isEmpty())  { m_ok = false; return 0; }
                z2 = m_stack.pop();
                input();
                return z1 * z2;
            case '/':
                if (m_stack.isEmpty())  { m_ok = false; return 0; }
                z1 = m_stack.pop();
                if (m_stack.isEmpty())  { m_ok = false; return 0; }
                z2 = m_stack.pop();
                input();
                return z2 / z1;
            default:
                return zahl();
        }
    }
    
    void rechnung() {
        int z;
        
        z = zahl();
        while(m_ok) {
            m_stack.push(z);
            z = operation();
        }
        if (m_stack.isEmpty()) {
            System.out.println("Fehler");
        } else {
            System.out.println("Resultat: " + m_stack.pop());
            if (!m_stack.isEmpty()) {
                System.out.println("Stackinhalt:");
                m_stack.show("");
            }
        }
    }
    
    void input() {
        try {
            m_c = (char)System.in.read();
            if (m_c == 13) {
                System.out.println();
            } else {
                System.out.print(m_c);
            }
            if (m_c == 27) m_ok = false;
        } catch(IOException e) {
            m_ok = false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Post-Fix Taschenrechner");
        System.out.println("kann mit Esc verlassen werden");
        StackComputer sc = new StackComputer();
        sc.input();
        sc.rechnung();
    }
}
