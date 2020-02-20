#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <algorithm>
#include <set>
#include <cassert>
using namespace std;

struct Node
{
    Node *next;
    Node *prev;
    int value;
    int key;
    Node(Node *p, Node *n, int k, int val) : prev(p), next(n), key(k), value(val){};
    Node(int k, int val) : prev(NULL), next(NULL), key(k), value(val){};
};

class Cache
{

protected:
    map<int, Node *> mp;            //map the key to the node in the linked list
    int cp;                         //capacity
    Node *tail;                     // double linked list tail pointer
    Node *head;                     // double linked list head pointer
    virtual void set(int, int) = 0; //set function
    virtual int get(int) = 0;       //get function
};

class LRUCache : public Cache
{
private:
    void visit(int key)
    {
        if (mp.count(key) == 1)
        {
            Node *node = mp[key];
            if (node != head)
            {
                Node *prev = node->prev;
                Node *next = node->next;

                prev->next = next;
                if (next != nullptr)
                {
                    next->prev = prev;
                }

                node->prev = nullptr;
                node->next = head;

                if (head != nullptr)
                {
                    head->prev = node;
                }
                head = node;
            }
        }
        else
        {
            Node *node{new Node{key, 0}};
            node->next = head;
            if (head != nullptr)
            {
                head->prev = node;
            }
            head = node;
            if (tail == nullptr)
            {
                tail = node;
            }

            mp[key] = node;

            if (mp.size() == cp + 1)
            {
                Node *p = tail;
                tail = tail->prev;

                mp.erase(mp.find(p->key));
                delete p;
            }
        }
    }

public:
    LRUCache(int cp)
    {
        this->cp = cp;
        head = nullptr;
        tail = nullptr;
    }

    ~LRUCache()
    {
        for (const auto &entry : mp)
        {
            delete entry.second;
        }
    }

    void set(int key, int value)
    {
        visit(key);

        mp[key]->value = value;
    }

    int get(int key)
    {
        if (mp.count(key) == 0)
        {
            return -1;
        }

        visit(key);

        return mp[key]->value;
    }
};

int main()
{
    int n, capacity, i;
    cin >> n >> capacity;
    LRUCache l(capacity);
    for (i = 0; i < n; i++)
    {
        string command;
        cin >> command;
        if (command == "get")
        {
            int key;
            cin >> key;
            cout << l.get(key) << endl;
        }
        else if (command == "set")
        {
            int key, value;
            cin >> key >> value;
            l.set(key, value);
        }
    }
    return 0;
}
