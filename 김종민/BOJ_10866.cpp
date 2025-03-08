#include <iostream>
#include <deque>
#include <string>

auto deque = std::deque<int>();

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto loop_count = 0;
    std::cin >> loop_count;

    auto command = std::string();
    for(int i = 0; i < loop_count; i++)
    {
        std::cin >> command;

        if(command == "push_back")
        {
            auto arg = 0;
            std::cin >> arg;

            deque.push_back(arg);
        }
        else if(command == "push_front")
        {
            auto arg = 0;
            std::cin >> arg;

            deque.push_front(arg);
        }
        else if(command == "pop_front")
        {
            if(deque.empty())
            {
                std::cout << -1 << '\n';
                continue;
            }

            std::cout << deque.front() << '\n';
            deque.pop_front();
        }
        else if(command == "pop_back")
        {
            if(deque.empty())
            {
                std::cout << -1 << '\n';
                continue;
            }

            std::cout << deque.back() << '\n';
            deque.pop_back();
        }
        else if(command == "size")
        {
            std::cout << deque.size() << '\n';
        }
        else if(command == "empty")
        {
            std::cout << deque.empty() << '\n';
        }
        else if(command == "front")
        {
            if(deque.empty())
            {
                std::cout << -1 << '\n';
                continue;
            }

            std::cout << deque.front() << '\n';
        }
        else if(command == "back")
        {
            if(deque.empty())
            {
                std::cout << -1 << '\n';
                continue;
            }

            std::cout << deque.back() << '\n';
        }
    }

    return 0;
}