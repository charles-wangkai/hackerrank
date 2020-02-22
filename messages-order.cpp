#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Message
{
private:
    int id;
    std::string text;

public:
    Message(int id, const std::string &text)
        : id{id}, text{text} {}

    int get_id() const
    {
        return id;
    }

    const string &get_text() const
    {
        return text;
    }
};

class MessageFactory
{
private:
    int id{0};

public:
    Message create_message(const string &text)
    {
        ++id;

        return Message{id, text};
    }
};

bool operator<(const Message &m1, const Message &m2)
{
    return m1.get_id() < m2.get_id();
}

class Recipient
{
public:
    Recipient() {}
    void receive(const Message &msg)
    {
        messages_.push_back(msg);
    }
    void print_messages()
    {
        fix_order();
        for (auto &msg : messages_)
        {
            cout << msg.get_text() << endl;
        }
        messages_.clear();
    }

private:
    void fix_order()
    {
        sort(messages_.begin(), messages_.end());
    }
    vector<Message> messages_;
};

class Network
{
public:
    static void send_messages(vector<Message> messages, Recipient &recipient)
    {
        // simulates the unpredictable network, where sent messages might arrive in unspecified order
        random_shuffle(messages.begin(), messages.end());
        for (auto msg : messages)
        {
            recipient.receive(msg);
        }
    }
};

int main()
{
    MessageFactory message_factory;
    Recipient recipient;
    vector<Message> messages;
    string text;
    while (getline(cin, text))
    {
        messages.push_back(message_factory.create_message(text));
    }
    Network::send_messages(messages, recipient);
    recipient.print_messages();
}
