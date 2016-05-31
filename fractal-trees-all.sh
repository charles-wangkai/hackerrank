#!/usr/local/bin/bash

init_board() {
    row_num=63
    col_num=100

    for (( i = 0; i < row_num; i++ )); do
        for (( j = 0; j < col_num; j++ )); do
            board[$i,$j]="_"
        done
    done
}

print_board() {
    for (( i = 0; i < row_num; i++ )); do
        for (( j = 0; j < col_num; j++ )); do
            echo -n "${board[$i,$j]}"
        done
        echo
    done
}

iterate() {
    local remain="$1"
    local size="$2"
    local start_row="$3"
    local start_col="$4"

    if [[ "$remain" -eq 0 ]]; then
        return
    fi

    for (( i = start_row; i > start_row - size; i-- )); do
        board[$i,$start_col]="1"
    done

    for (( i = start_row - size; i > start_row - size * 2; i-- )); do
        board[$i,$((start_col - (start_row - size - i + 1)))]="1"
        board[$i,$((start_col + (start_row - size - i + 1)))]="1"
    done

    iterate $((remain - 1)) $((size / 2)) $((start_row - size * 2)) $((start_col - size))
    iterate $((remain - 1)) $((size / 2)) $((start_row - size * 2)) $((start_col + size))
}

main() {
    declare -A board

    init_board

    read N
    iterate $N 16 62 49

    print_board
}

main
