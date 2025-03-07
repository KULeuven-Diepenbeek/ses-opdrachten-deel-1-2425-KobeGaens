import sys
from model import friendshiptester

def main():
    decimal = False
    # Controleer of de flag -dec is meegegeven
    if len(sys.argv) > 1 and sys.argv[1] == "-dec":
        decimal = True

    # Vraag de eerste naam
    name1 = input("Voer de eerste naam in: ").strip()
    
    # Vraag de tweede naam
    name2 = input("Voer de tweede naam in: ").strip()
    
    # Bereken de vriendschapsscore
    score = friendshiptester.calculate_friendship(name1, name2)
    
    # Toon de score volgens de gekozen flag
    if decimal:
        print("De vriendschapscore is: {:.2f}".format(score))
    else:
        print("De vriendschapscore is: {}".format(int(score)))

if __name__ == '__main__':
    main()
