module Main where

import qualified Data.Sequence as S
import Data.Sequence( Seq, ViewL( (:<), EmptyL ), viewl , (|>), (<|), (><), empty )
import Data.Foldable(toList)

type String' = Seq Char

viewL2Seq EmptyL    = empty
viewL2Seq (c :< tl) = c <| tl

preffixCompression :: String' -> String' -> (String', String', String')
preffixCompression s1 s2 = preffixs empty (viewl s1) (viewl s2)
    where preffixs acc (c1 :< tl1) (c2 :< tl2) | c1 == c2 = preffixs (acc |> c1) (viewl tl1) (viewl tl2)
          preffixs acc v1          v2                     = (acc, viewL2Seq v1, viewL2Seq v2) 

formatString :: String' -> String'
formatString s = if S.null s 
                 then S.singleton '0'
                 else (S.fromList $ show $ S.length s) >< (S.singleton ' ') >< s

printAnswer :: (String', String', String') -> IO ()
printAnswer (s1,s2,s3) = printStr s1 >> printStr s2 >> printStr s3
    where printStr = putStrLn . toList . formatString 

readInput :: IO (String', String')
readInput = let readLn = fmap S.fromList getLine
            in do
                s1 <- readLn
                s2 <- readLn
                return (s1,s2)

main :: IO ()
main = do
        (s1,s2) <- readInput
        let answer = preffixCompression s1 s2
        printAnswer answer