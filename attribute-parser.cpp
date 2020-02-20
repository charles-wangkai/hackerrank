#include <iostream>
#include <unordered_map>
#include <vector>

std::string BuildTagPath(const std::vector<std::string> &tags)
{
    std::string result;
    for (const auto &tag : tags)
    {
        if (!result.empty())
        {
            result += ".";
        }

        result += tag;
    }

    return result;
}

int main()
{
    std::unordered_map<std::string, std::unordered_map<std::string, std::string>> tag_path_to_attributes;
    std::vector<std::string> tags;

    int N;
    int Q;
    std::cin >> N >> Q;

    std::string line;
    std::getline(std::cin, line);
    for (int i{0}; i < N; ++i)
    {
        std::getline(std::cin, line);
        std::string body{line.substr(1, line.size() - 2)};

        if (body[0] != '/')
        {
            std::string::size_type index{body.find(' ')};
            std::string tag{body.substr(0, index)};

            tags.push_back(tag);

            std::string tag_path{BuildTagPath(tags)};
            if (tag_path_to_attributes.find(tag_path) == tag_path_to_attributes.end())
            {
                tag_path_to_attributes[tag_path] = std::unordered_map<std::string, std::string>{};
            }

            while (index != std::string::npos)
            {
                std::string::size_type space_index1{body.find(' ', index + 1)};
                std::string::size_type space_index2{body.find(' ', space_index1 + 1)};
                std::string::size_type space_index3{body.find(' ', space_index2 + 1)};

                std::string attr_name{body.substr(index + 1, space_index1 - index - 1)};
                std::string attr_value{body.substr(space_index2 + 2, std::min(body.size(), space_index3) - space_index2 - 3)};

                tag_path_to_attributes[tag_path][attr_name] = attr_value;

                index = space_index3;
            }
        }
        else
        {
            tags.pop_back();
        }
    }

    for (int i{0}; i < Q; ++i)
    {
        std::string query;
        std::cin >> query;

        std::string::size_type index{query.find('~')};
        std::string tag_path{query.substr(0, index)};
        std::string attr_name{query.substr(index + 1)};

        if (tag_path_to_attributes[tag_path].find(attr_name) != tag_path_to_attributes[tag_path].end())
        {
            std::cout << tag_path_to_attributes[tag_path][attr_name] << "\n";
        }
        else
        {
            std::cout << "Not Found!\n";
        }
    }

    return 0;
}