solve :: Int -> Int -> Int
solve = (+)

main = do
    a <- readLn
    b <- readLn
    print $ solve a b