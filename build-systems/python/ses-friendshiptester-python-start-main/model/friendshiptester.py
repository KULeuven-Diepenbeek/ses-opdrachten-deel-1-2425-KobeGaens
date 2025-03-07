def calculate_friendship(name1, name2):
    # Tel de ASCII-waarden van alle karakters in beide namen op
    total = sum(ord(c) for c in name1) + sum(ord(c) for c in name2)
    # Bereken een score tussen 0 en 100 (inclusief 100, dus modulo 101)
    score = total % 101
    return score