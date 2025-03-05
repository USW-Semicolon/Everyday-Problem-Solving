#include <iostream>
#include <queue>
#include <string>

auto queue = std::queue<int>();
auto answers = std::queue<int>();

void Push(int num)
{
    queue.push(num);
}

void Pop()
{
    if(queue.empty())
    {
        answers.push(-1);
        return;
    }

    auto temp = queue.front();
    queue.pop();

    answers.push(temp);
}

void Size()
{
    answers.push(queue.size());
}

void Empty()
{
    if(queue.empty())
    {
        answers.push(1);
        return;
    }

    answers.push(0);
}

void Front()
{
    if(queue.empty())
    {
        answers.push(-1);
        return;
    }

    answers.push(queue.front());
}

void Back()
{
    if(queue.empty())
    {
        answers.push(-1);
        return;
    }

    answers.push(queue.back());
}

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto loop_count = 0;
    std::cin >> loop_count;

    auto input_str = std::string();
    for(int i = 0; i < loop_count; i++)
    {
        std::cin >> input_str;

        if(input_str == "push")
        {
            auto arg = 0;
            std::cin >> arg;

            Push(arg);
        }
        else if(input_str == "pop")
        {
            Pop();
        }
        else if(input_str == "size")
        {
            Size();
        }
        else if(input_str == "empty")
        {
            Empty();
        }
        else if(input_str == "front")
        {
            Front();
        }
        else if(input_str == "back")
        {
            Back();
        }
    }

    while(!answers.empty())
    {
        std::cout << answers.front() << '\n';
        answers.pop();
    }

    return 0;
}