main = do
    n <- readLn
    mapM_ putStrLn $ replicate n "Hello World"