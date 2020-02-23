#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Spell
{
private:
    string scrollName;

public:
    Spell() : scrollName("") {}
    Spell(string name) : scrollName(name) {}
    virtual ~Spell() {}
    string revealScrollName()
    {
        return scrollName;
    }
};

class Fireball : public Spell
{
private:
    int power;

public:
    Fireball(int power) : power(power) {}
    void revealFirepower()
    {
        cout << "Fireball: " << power << endl;
    }
};

class Frostbite : public Spell
{
private:
    int power;

public:
    Frostbite(int power) : power(power) {}
    void revealFrostpower()
    {
        cout << "Frostbite: " << power << endl;
    }
};

class Thunderstorm : public Spell
{
private:
    int power;

public:
    Thunderstorm(int power) : power(power) {}
    void revealThunderpower()
    {
        cout << "Thunderstorm: " << power << endl;
    }
};

class Waterbolt : public Spell
{
private:
    int power;

public:
    Waterbolt(int power) : power(power) {}
    void revealWaterpower()
    {
        cout << "Waterbolt: " << power << endl;
    }
};

class SpellJournal
{
public:
    static string journal;
    static string read()
    {
        return journal;
    }
};
string SpellJournal::journal = "";

void counterspell(Spell *spell)
{
    Fireball *fireball_spell{dynamic_cast<Fireball *>(spell)};
    if (fireball_spell)
    {
        fireball_spell->revealFirepower();

        return;
    }

    Frostbite *frostbite_spell{dynamic_cast<Frostbite *>(spell)};
    if (frostbite_spell)
    {
        frostbite_spell->revealFrostpower();

        return;
    }

    Waterbolt *waterbolt_spell{dynamic_cast<Waterbolt *>(spell)};
    if (waterbolt_spell)
    {
        waterbolt_spell->revealWaterpower();

        return;
    }

    Thunderstorm *thunderstorm_spell{dynamic_cast<Thunderstorm *>(spell)};
    if (thunderstorm_spell)
    {
        thunderstorm_spell->revealThunderpower();

        return;
    }

    const std::string &s1{spell->revealScrollName()};
    const std::string &s2{SpellJournal::read()};

    std::string::size_type size1{s1.size()};
    std::string::size_type size2{s2.size()};

    std::vector<std::vector<int>> lcs(size1 + 1, std::vector<int>(size2 + 1));
    for (int i{1}; i <= size1; ++i)
    {
        for (int j{1}; j <= size2; ++j)
        {
            if (s1[i - 1] == s2[j - 1])
            {
                lcs[i][j] = lcs[i - 1][j - 1] + 1;
            }
            else
            {
                lcs[i][j] = std::max(lcs[i - 1][j], lcs[i][j - 1]);
            }
        }
    }

    std::cout << lcs[size1][size2] << "\n";
}

class Wizard
{
public:
    Spell *cast()
    {
        Spell *spell;
        string s;
        cin >> s;
        int power;
        cin >> power;
        if (s == "fire")
        {
            spell = new Fireball(power);
        }
        else if (s == "frost")
        {
            spell = new Frostbite(power);
        }
        else if (s == "water")
        {
            spell = new Waterbolt(power);
        }
        else if (s == "thunder")
        {
            spell = new Thunderstorm(power);
        }
        else
        {
            spell = new Spell(s);
            cin >> SpellJournal::journal;
        }
        return spell;
    }
};

int main()
{
    int T;
    cin >> T;
    Wizard Arawn;
    while (T--)
    {
        Spell *spell = Arawn.cast();
        counterspell(spell);
    }
    return 0;
}