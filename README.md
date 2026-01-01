# Caesar Cipher Suite (Java)

A Java project implementing a classical Caesar cipher system along with 
cryptanalysis techniques to explore encryption, key recovery, and 
limitations of substitution ciphers.

## Overview
This project demonstrates how simple encryption schemes can be systematically 
broken. It was built to practice Java programming and understand 
fundamental cryptography concepts, including statistical analysis of text.

## Programs Included
- **Encrypt** – Encrypts plaintext using a randomly generated Caesar shift.
- **BruteForce** – Tries all 25 possible keys to recover plaintext.
- **FrequencyAnalysis** – Estimates the key by analyzing letter frequency.

## Technical Concepts
- File input/output and character processing in Java
- Modular arithmetic for character shifting
- Brute-force vs heuristic-based key recovery
- Statistical reasoning in classical cryptography

## How to Run
Compile and run with a single command:
```bash
javac *.java && java Encrypt
