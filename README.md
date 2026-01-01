# Caesar Cipher Suite (Java)

A Java project exploring classical encryption and cryptanalysis 
through the implementation of a Caesar cipher system.

## Overview
This project was built to understand how simple ciphers work and 
why they fail under analysis. It demonstrates encryption, 
key recovery, and the practical limitations of substitution ciphers.

## Programs Included
- **Encrypt** – Encrypts text using a randomly chosen Caesar shift.
- **BruteForce** – Recovers plaintext by trying all possible shifts.
- **FrequencyAnalysis** – Estimates the key using letter frequency patterns.

## Skills & Concepts
- Java file I/O and string processing
- Modular arithmetic for character shifting
- Brute-force vs heuristic key recovery
- Applying statistical analysis to classical ciphers

## How to Run
Compile and run with:
```bash
javac *.java && java Encrypt
